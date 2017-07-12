
public class Grid {

	public static void makeGrid(Node grid, int cellNumber) {
		
		for (int row = 0; row < cellNumber; row++) {
			for (int col = 0; col < cellNumber; col++) {
				grid.serialNo = row+col;
				grid.status = "0";
				System.out.print(grid.serialNo + "   ");
			}
			System.out.println();
		}
		
	}
}
