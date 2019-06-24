package model;

public class Action {
	private int[] actionCode = new int[2];
	
	public Action(int hor, int ver){
		actionCode[0] = hor;
		actionCode[1] = ver;
	}

	public int[] getActionCode() {
		return actionCode;
	}
	
	public boolean isEqual(Action action){
		return ((this.actionCode[0] == action.getActionCode()[0]) && (this.actionCode[1] == action.getActionCode()[1]));
	}
	
	
	
}
