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
	static List visited = new ArrayList<Integer>();

	public static void DFSsearch(Node[][] grid, int length) {
		
		//boolean hey = visited.contains("1"); <---- this works, not needed for now
		//System.out.println(grid.serialNo);
		
	}
	
	
}
