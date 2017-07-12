/*change String[][] to node with blocked/unblocked, serial number (to determine neighbor)
0	1	2	3	4
5	6	7	8	9
10	11	12	13	14		<--- 5x5 grid
15	16	17	18	19	
20	21	22	23	24
*/

import java.util.*;

public class DFSgraph {

	Stack stack = new Stack();
	static List visited = new ArrayList<String[][]>();

	public static void DFSsearch(String[][] grid, int row, int col) {
		
		//boolean hey = visited.contains("1"); <---- this works, not needed for now
		
		if (grid[row][col] == "0") {
			visited.add(grid[row][col]);
			//neighbors
			if (row == 0 && (col < grid.length-1)) {
				visited(grid,row,col);
			} else if (row == grid.length-1) {
				
			} else if (col == 0) {
				
			} else if (col == grid.length-1) {
				
			} else if (row == 0 && col == grid.length-1) {
				
			} else if (row == grid.length-1 && col == 0) {
				
			}
		}
	}
	
	public static void visited(String[][] grid, int row, int col) {
		if (grid[row][col] == "0") {
			visited.add(grid[row][col]);
			grid[row][col] = "1";
			
		}
	}
}
