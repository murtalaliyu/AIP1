/*change String[][] to node with blocked/unblocked, serial number (to determine neighbor)
0	1	2	3	4
5	6	7	8	9
10	11	12	13	14		<--- 5x5 grid
15	16	17	18	19	
20	21	22	23	24
*/

import java.util.ArrayList;
import java.util.Stack;

public class DFSgraph {

	static Stack stack = new Stack<Node>();
	static ArrayList visited = new ArrayList<Node>();

	public static Node[][] DFSsearch(Node[][] grid, Node node) {
	
		
		if (node.status == "0" && !visited.contains(node)) {
			visited.add(node);
			grid[node.first][node.second].status = "1";
			
			//get this node's neighbors and add to stack
			int x = node.first;
			int y = node.second;
			Node newNeighbor = null;
			//top
			if (x-1 >= 0) {
				if (grid[x-1][y].status == "0") {
					newNeighbor.first = x-1;
					newNeighbor.second = y;
					newNeighbor.status = grid[x-1][y].status;
					stack.push(newNeighbor);
				}
			} 
			if (x+1 < grid.length) {
				if (grid[x+1][y].status == "0") {
					newNeighbor.first = x+1;
					newNeighbor.second = y;
					newNeighbor.status = grid[x+1][y].status;
					stack.push(newNeighbor);
				}
			}
			if (y-1 >= 0) { 
				if (grid[x][y-1].status == "0") {
					newNeighbor.first = x;
					newNeighbor.second = y-1;
					newNeighbor.status = grid[x][y-1].status;
					stack.push(newNeighbor);
				}
			}
			if (y+1 < grid.length) {
				if (grid[x][y+1].status == "0") {
					newNeighbor.first = x;
					newNeighbor.second = y+1;
					newNeighbor.status = grid[x][y+1].status;
					stack.push(newNeighbor);
				}
			}
			//pop stack and call dfs on node
			grid = DFSsearch(grid,(Node)stack.pop());
			System.out.println(stack);
		}
		
		return grid;
	}
}
