package model;

public class State {
	private int[][] state = new int[3][3];
	
	private int blackPosition;
	private int blankRow;
	private int blankCol;
	
	public State(String stateString){
		generateState(stateString);
	}
	
	public State(int[][] state){
		this.state = state;	
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				if(this.state[row][col] ==  0){
					blankRow = row;
					blankCol = col;
					blackPosition = Position.position(blankRow, blankCol);
				}
			}
		}
	}
	
	/*
	 * returns the row that the blank space is in
	 */
	public int getBlankRow() {
		return blankRow;
	}
	
	/*
	 * returns the column that the blank space is in
	 */
	public int getBlankCol() {
		return blankCol;
	}
	
	/*
	 * takes string input and generates the integer version of the state with zero(0)
	 * representing the blank tile.
	 */
	private void generateState(String stateString){
		int charPosition = 0;
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				if(Character.isDigit(stateString.charAt(charPosition))){
					state[row][col] = Integer.parseInt(""+stateString.charAt(charPosition));
				}
				else{
					state[row][col] = 0;
					blankRow = row;
					blankCol = col;
					blackPosition = Position.position(blankRow, blankCol);
				}
				charPosition++;
			}
		}
	}
	
	/*
	 * returns true if anotherState is equal to this state 
	 */
	public boolean isEqual(State anotherState){
		int[][] state = anotherState.getStatecode();
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				if(this.state[row][col] != state[row][col])
					return false;
			}
		}
		
		return true;
	}
	
	/*
	 * returns state array
	 */
	public int[][] getStatecode() {
		return state;
	}


	public int getBlackPosition() {
		return blackPosition;
	}
	
	
	public String toString(){
		StringBuffer string = new StringBuffer("");
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				if(state[row][col] == 0)
					string.append(" ");
				else
					string.append(state[row][col]);
			}
			string.append("\n");
		}
		
		return string.toString();
	}
}
