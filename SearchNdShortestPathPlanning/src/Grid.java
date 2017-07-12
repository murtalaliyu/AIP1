
public class Grid {

	public static void makeGrid(Node grid, int cellNumber) {
		int sum = 0;
		for (int row = 0; row < cellNumber; row++) {
			for (int col = 0; col < cellNumber; col++) {
				grid.serialNo = row+col+sum;
				grid.status = "0";
				System.out.print(grid.serialNo + "   ");
			}
			sum += cellNumber-1;
			System.out.println();
		}
		
	}
}
