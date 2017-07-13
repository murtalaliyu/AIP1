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
