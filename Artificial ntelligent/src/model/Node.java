package model;

public class Node implements Comparable<Node>{
	public State state; // state of the node
	public Action action; // action that resulted to the current state
	public Node parent; // parent node 
	public int g; // depth cost of node
	public int pathCost; //path cost of node
	
	
	public Node(State state, Action action, Node parent) {
		this(state, action, parent, 0);
		
		
	}
	
	public Node(State state, Action action, Node parent, int cost){
		this.state = state;
		this.action = action;
		this.parent = parent;
		this.g = cost;
	}
	
	/*
	 * returns true if another node is equal to this one
	 */
	public boolean equals(Node another){
		
		return this.pathCost == another.pathCost;
	}

	@Override
	public int compareTo(Node o) {
		if(this.equals(o))
			return 0;
		else if(this.pathCost > o.pathCost)
			return 1;
		else
			return -1;
	}
	
}
