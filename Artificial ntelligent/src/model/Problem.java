package model;

import java.util.ArrayList;

public class Problem {
	public static final Action 	UP = new Action(0, 1),
								DOWN = new Action(0, -1),
								LEFT = new Action(-1, 0),
								RIGHT = new Action(1, 0);
	private State initialState, goalState;
	
	public Problem(State initialState, State goalState) {
		super();
		this.initialState = initialState;
		this.goalState = goalState;
	}

	public State getInitialState() {
		return initialState;
	}
	
	public boolean isGoalState(State state){
		return goalState.isEqual(state);
	}
	
	
	/*
	 * returns an array of actions that are legal for a particular state.
	 */
	public ArrayList<Action> actions(State state){
		ArrayList<Action> actions = new ArrayList<Action>();
		int blankPosition = state.getBlackPosition();
		
		if(blankPosition == Position.TOP_LEFT){
			actions.add(DOWN);
			actions.add(RIGHT);
		}
		if(blankPosition == Position.TOP_CENTER){
			actions.add(DOWN);
			actions.add(RIGHT);
			actions.add(LEFT);
		}
		if(blankPosition == Position.TOP_RIGHT){
			actions.add(DOWN);
			actions.add(LEFT);
		}
		
		if(blankPosition == Position.MIDDLE_LEFT){
			actions.add(DOWN);
			actions.add(UP);
			actions.add(RIGHT);
		}
		if(blankPosition == Position.CENTER){
			actions.add(UP);
			actions.add(DOWN);
			actions.add(LEFT);
			actions.add(RIGHT);
		}
		if(blankPosition == Position.MIDDLE_RIGHT){
			actions.add(UP);
			actions.add(DOWN);
			actions.add(LEFT);
		}
		if(blankPosition == Position.BUTTOM_LEFT){
			actions.add(UP);
			actions.add(RIGHT);
		}
		if(blankPosition == Position.BUTTOM_CENTER){
			actions.add(UP);
			actions.add(LEFT);
			actions.add(RIGHT);
		}
		if(blankPosition == Position.BUTTOM_RIGHT){
			actions.add(UP);
			actions.add(LEFT);
		}
		return actions;
	}
	
	/*
	 * returns a child node generated from an action applied to a given state
	 */
	public Node childNode(Node node, Action action){
		int[][] nodeState = node.state.getStatecode();
		int[][] stateCode = new int[3][3];
		
		//copy state code by value
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				stateCode[row][col] = nodeState[row][col];
			}
		}
		int blankHor = node.state.getBlankRow();
		int blankVer = node.state.getBlankCol();
			
		if(action.isEqual(UP))
			blankHor -= 1;
		else if(action.isEqual(DOWN))
			blankHor += 1;
		else if(action.isEqual(LEFT))
			blankVer -= 1;
		else if(action.isEqual(RIGHT))
			blankVer += 1;
		
		stateCode[node.state.getBlankRow()][node.state.getBlankCol()] = 
				stateCode[blankHor][blankVer];
		stateCode[blankHor][blankVer] = 0;
		
		State newState = new State(stateCode);
		Node t = new Node(newState, action, node);
		t.g = node.g + 1;
		return t;
	}

	public State getGoalState() {
		return goalState;
	}
	
	/*
	public State getGoalState() {
		return goalState;
	}
	
	*/
	
	
}
