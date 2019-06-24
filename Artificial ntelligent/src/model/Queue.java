package model;

import java.util.PriorityQueue;

public class Queue<Node> extends PriorityQueue<Node>{
	public Queue(){
		super();
	}
	
	public Node get(Node p){
		int size = this.size();
		for(int i = 0; i < size; i++){
			Node t = remove();
			if(t.equals(p))
				return t;
				break;
		}
		return null;
	}
}
