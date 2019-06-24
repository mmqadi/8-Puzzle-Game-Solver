package model;

public class Position {
	public static final int TOP_LEFT = 0,
			TOP_CENTER = 1,
			TOP_RIGHT = 2,
			MIDDLE_LEFT = 3,
			CENTER = 4,
			MIDDLE_RIGHT = 5,
			BUTTOM_LEFT = 6,
			BUTTOM_CENTER = 7,
			BUTTOM_RIGHT = 8;
	
	private int value;
	
	
	public int getValue() {
		return value;
	}
	
	/*
	 * returns the position code of the blank space
	 */
	public static int position(int row, int col){
		if(row == 0 && col ==0)
			return TOP_LEFT;
		if(row == 0 && col ==1)
			return TOP_CENTER;
		if(row == 0 && col ==2)
			return TOP_RIGHT;
		if(row == 1 && col ==0)
			return MIDDLE_LEFT;
		if(row == 1 && col ==1)
			return CENTER;
		if(row == 1 && col ==2)
			return MIDDLE_RIGHT;
		if(row == 2 && col ==0)
			return BUTTOM_LEFT;
		if(row == 2 && col ==1)
			return BUTTOM_CENTER;
		else{
			return BUTTOM_RIGHT;
		}
	}
	
	
			
}
