
public class Grid {

	public static void makeGrid(Node[][] grid) {
		int sum = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				grid[row][col].serialNo = row+col+sum;
				grid[row][col].status = "0";
				System.out.print(grid[row][col].serialNo + "   ");
			}
			sum += grid.length-1;
			System.out.println();
		}
	}
}
