package main;

import java.util.LinkedList;
import java.util.Scanner;

import algorithm.Algorithm;
import model.Problem;
import model.State;

public class Application {

	public static void main(String[] args) {
		State goalState;
		State initialState;
		State anotherOne = new State("281b43765");
		State hard = new State("281463b75");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an initial state of the 8 puzzle game in the form: 281463b75");
		String stateString = input.next();
		
		initialState = new State(stateString);
		
		System.out.println("Enter an goal state of the 8 puzzle game in the form: 281463b75");
		stateString = input.next();
		goalState = new State(stateString);
		
		Problem puzzle8 = new Problem(initialState,goalState);
		
		LinkedList<State> path = null;;
		
		System.out.println("Choose algorithm you want to use: 0: BreadthFirst, 1:DepthFirst, 2: A* algorithm");
		int choice = input.nextInt();
		
		switch(choice){
		case 0:
			path = Algorithm.breadthFirst(puzzle8);
			break;
		case 1:
			path = Algorithm.DepthFirst(puzzle8);
			break;
			
		case 2:
			path = Algorithm.AStar(puzzle8);
		}
		
		
		System.out.println("Solution path below");
		for(State state: path){
			System.out.println(state);
		}
		
		System.out.println("done!!");
		
	}

}
