import java.util.ArrayList;
import java.util.Stack;

public class DFSgraph {

	static Stack stack = new Stack<Node>();
	static ArrayList visited = new ArrayList<Node>();

	public static Node[][] DFSsearch(Node[][] grid, Node node) {
		
		if (node.first*node.second == (grid.length-1)*(grid.length-1)) {
			grid[node.first][node.second].status = "1";
			return grid;
		}
		
		//do {
			visited.add(node);
			grid[node.first][node.second].status = "1";
			
			//get this node's neighbors and add to stack
			int x = node.first;
			int y = node.second;
			Node newNeighbor = new Node(0,0,"0");
			Object object = new Object();
			//top
			object = x-1;
			if (object instanceof Integer == true) {
				if ((int)object != -1) {
					if (grid[x-1][y].status == "0") {
						newNeighbor.first = x-1;
						newNeighbor.second = y;
						newNeighbor.status = grid[x-1][y].status;
						stack.push(newNeighbor);
					}
				}
			} 
			object = x+1;
			if (object instanceof Integer == true) {
				if ((int)object != grid.length) {
					if (grid[x+1][y].status == "0") {
						newNeighbor.first = x+1;
						newNeighbor.second = y;
						newNeighbor.status = grid[x+1][y].status;
						stack.push(newNeighbor);
					}
				}
			}
			object = y-1;
			if (object instanceof Integer == true) {
				if ((int)object != -1) { 
					if (grid[x][y-1].status == "0") {
						newNeighbor.first = x;
						newNeighbor.second = y-1;
						newNeighbor.status = grid[x][y-1].status;
						stack.push(newNeighbor);
					}
				}
			}
			object = y+1;
			if (object instanceof Integer == true) {
				if ((int)object != grid.length) {
					if (grid[x][y+1].status == "0") {
						newNeighbor.first = x;
						newNeighbor.second = y+1;
						newNeighbor.status = grid[x][y+1].status;
						stack.push(newNeighbor);
					}
				}
			}
			
			//pop stack and call dfs on node
			for (int i = 0; i < stack.size(); i++) {
				grid = DFSsearch(grid,(Node)stack.pop());
			}
		//} while (stack.empty() == false);
		
		return grid;
	}
}
