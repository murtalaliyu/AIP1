import java.util.*;

public class DFSgraph {

	public static void DFSsearch(String[][] grid, int row, int col) {
		Stack stack = new Stack();
		List visited = new ArrayList<String[][]>();
		
		if (grid[row][col] == "0") {
			visited.add(grid[row][col]);
			//neighbors
			if (row == 0) {
				
			} else if (row == grid.length-1) {
				
			} else if (col == 0) {
				
			} else if (col == grid.length-1) {
				
			} else if (row == 0 && col == grid.length-1) {
				
			} else if (row == grid.length-1 && col == 0) {
				
			}
		}
	}
}
