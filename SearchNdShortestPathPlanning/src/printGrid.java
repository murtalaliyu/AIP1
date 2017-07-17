
public class printGrid {

	public static void printGrid(Node[][] grid) {
		for (int i = 0; i < grid.length; i++) { 
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j].status + "   ");
			}
			System.out.println();
		}
	}
}
