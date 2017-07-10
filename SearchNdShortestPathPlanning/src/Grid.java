
public class Grid {

	int cellNumber = 10;
	String[][] grid = new String[cellNumber][cellNumber];
	
	public static void makeGrid(String[][] grid, int cellNumber) {
		
		for (int row = 0; row < cellNumber; row++) {
			for (int col = 0; col < cellNumber; col++) {
				grid[row][col] = "0";
				System.out.print(grid[row][col] + "   ");
			}
			System.out.println();
		}
		
	}
}
