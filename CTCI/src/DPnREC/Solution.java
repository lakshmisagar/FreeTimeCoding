package DPnREC;

public class Solution {
	static int row = 4;
	static int col = 3;
	static int matrix[][] = new int[row][col];

	private static int robotPathWays(int row, int col) {
		if(row == 0 || col == 0)return 1;
		if(matrix[row][col]!= 0){
			return matrix[row][col];
		}
		return robotPathWays(row-1, col)+robotPathWays(row, col-1);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(robotPathWays(row-1,col-1));
	}


}
