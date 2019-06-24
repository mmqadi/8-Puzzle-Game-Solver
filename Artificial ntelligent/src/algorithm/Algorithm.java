package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import model.Action;
import model.Node;
import model.Problem;
import model.State;

public class Algorithm {
	
	/*
	 * Breadth First Search
	 * return solution path if solution is found or null if not 
	 */
	public static LinkedList<State> breadthFirst(Problem problem){
		Node root = new Node(problem.getInitialState(), null, null);
		if(problem.isGoalState(root.state))
			return solution(root);
		
		//holds the nodes that are open
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.offer(root);
		
		//holds the nodes that are closed
		LinkedList<Node> explored = new LinkedList<Node>();
		while(!frontier.isEmpty()){
			Node node = frontier.poll();
			explored.add(node);
			
			ArrayList<Action> list = problem.actions(node.state);
		//	System.out.println(node.state);
			for(int i = 0; i < list.size(); i++){
				Node child = problem.childNode(node, list.get(i));
				if(!(frontier.contains(child) || explored.contains(child))){
					if(problem.isGoalState(child.state)){
						return solution(child);
					}
					
					frontier.offer(child);
				}
			}	
		}
		return null;
	}
	
	/*
	 * A star Search Algorithm
	 * returns a solution path or null if no solution is found
	 */
	public static LinkedList<State> AStar(Problem problem){
		Node root = new Node(problem.getInitialState(), null, null);
		if(problem.isGoalState(root.state))
			return solution(root);
		
		PriorityQueue<Node>  frontier = new PriorityQueue<Node>();
		frontier.offer(root);
		LinkedList<Node> explored = new LinkedList<Node>();
		
		while(!frontier.isEmpty()){
			Node node = frontier.remove();
			if(problem.isGoalState(node.state))
				return solution(node);
			else {
				ArrayList<Action> list = problem.actions(node.state);
				for(Action action: list){
					Node child = problem.childNode(node, action);
					
					if(!(frontier.contains(child) || explored.contains(child))){
						child.pathCost = child.g + Algorithm.heuristic(child, problem.getGoalState());
						frontier.offer(child);
					}
					
				}
			}
			
			explored.add(node);
		}
		
		
		return null;
	}
	
	/*
	 * Depth First Search Algorithm
	 * returns a solution path or null if no solution is found
	 */
	public static LinkedList<State> DepthFirst(Problem problem){
		Node root = new Node(problem.getInitialState(), null, null);
		if(problem.isGoalState(root.state))
			return solution(root);
		Stack<Node> frontier = new Stack<Node>();
		LinkedList<Node> explored = new LinkedList<Node>();
		
		frontier.push(root);
		
		while(!frontier.isEmpty()){
			Node node = frontier.pop();
			explored.add(node);
			
			ArrayList<Action> actions = problem.actions(node.state);
			
			for(Action action: actions){
				Node child = problem.childNode(node, action);
				if(!frontier.contains(child) || explored.contains(child))
					if(problem.isGoalState(child.state))
						return solution(child);
				frontier.push(child);
			}
		}
		return null;
	}
	
	
	/*
	 * returns the path from the root node to a given node
	 */
	private static LinkedList<State> solution(Node node){
		LinkedList<State> path = new LinkedList<State>();
		
		while(node != null){
			path.add(node.state);
			node = node.parent;
		}
		
		Collections.reverse(path);
		
		return path;
	}
	
	/*
	 * Returns the heuristic value of a given state
	 */
	public static int heuristic(Node n, State goal){
		int count = 0;
		int[][] stateArray = n.state.getStatecode();
		for(int row = 0; row < 3; row++)
			for(int col = 0; col < 3; col++)
				if(stateArray[row][col] != goal.getStatecode()[row][col])
					count++;
			
		return count;
	}
}



