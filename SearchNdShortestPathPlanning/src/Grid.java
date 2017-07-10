
public class Grid {

	int cellNumber = 10;
	String[][] grid = new String[cellNumber][cellNumber];
	
	public static void makeGrid(String[][] grid, int cellNumber) {
		
		for (int i = 0; i < cellNumber; i++) {
			for (int j = 0; j < cellNumber; j++) {
				grid[i][j] = "0";
				System.out.print(grid[i][j] + "   ");
			}
			System.out.println();
		}
		
	}
}
