import java.util.*;

public class DFSgraph {

	static Stack<Node> stack = new Stack<Node>();
	static ArrayList<Node> visited = new ArrayList<Node>();

	public static Node[][] DFSsearch(Node[][] grid, Node node) {
		
		if (node.status.equals("G")) {
			System.out.println("Goal found!!!");
			return grid;
		}
		
		visited.add(node);
		grid[node.first][node.second].status = "1";
		
		/*System.out.println();
		System.out.println();
		//print updated path
		System.out.println(grid[node.first][node.second].first + "," + grid[node.first][node.second].second + " has been added to the path. now searching for its neighbors");
		System.out.println("updated path:");
		printGrid.printGrid(grid);
		}*/
		
		//get this node's neighbors and add to stack
		int x = node.first;
		int y = node.second;
		Node newNeighbor = new Node(0,0,"0");
		Node newNeighbor2 = new Node(0,0,"0");
		Node newNeighbor3 = new Node(0,0,"0");
		Node newNeighbor4 = new Node(0,0,"0");
		Object object = new Object();
		
		object = y-1;
		if (object instanceof Integer) {
			if ((int)object != -1) {
				if (grid[x][(int)object].status.equals("0") || grid[x][(int)object].status.equals("G")) {
					newNeighbor.first = x;
					newNeighbor.second = (int)object;
					newNeighbor.status = grid[x][(int)object].status;
					stack.push(newNeighbor);
					/*System.out.println("left is a neighbor. " + newNeighbor.first + "," + newNeighbor.second + " has been pushed to stack, now first to be popped: ");
					
					System.out.println("content of stack");
					for (int i = 0; i < stack.size(); i++) {
						System.out.println(stack.get(i).first + "," + stack.get(i).second);
					}*/
				}
			}
		} 
		object = x-1;
		if (object instanceof Integer == true) {
			if ((int)object != -1) { 
				if (grid[(int)object][y].status.equals("0") || grid[(int)object][y].status.equals("G")) {
					newNeighbor3.first = (int)object;
					newNeighbor3.second = y;
					newNeighbor3.status = grid[(int)object][y].status;
					stack.push(newNeighbor3);
					/*System.out.println("top is a neighbor. " + newNeighbor3.first + "," + newNeighbor3.second + " has been pushed to stack, now first to be popped: ");
				
					System.out.println("content of stack");
					for (int i = 0; i < stack.size(); i++) {
						System.out.println(stack.get(i).first + "," + stack.get(i).second);
					}*/
				}
			}
		}
		object = y+1;
		if (object instanceof Integer == true) {
			if ((int)object != grid.length) {
				if (grid[x][(int)object].status.equals("0") || grid[x][(int)object].status.equals("G")) {
					newNeighbor2.first = x;
					newNeighbor2.second = (int)object;
					newNeighbor2.status = grid[x][(int)object].status;
					stack.push(newNeighbor2);
					/*System.out.println("right is a neighbor. " + newNeighbor2.first + "," + newNeighbor2.second + " has been pushed to stack, now first to be popped: ");
				
					System.out.println("content of stack");
					for (int i = 0; i < stack.size(); i++) {
						System.out.println(stack.get(i).first + "," + stack.get(i).second);
					}*/
				}
			}
		}
		object = x+1;
		if (object instanceof Integer == true) {
			if ((int)object != grid.length) {
				if (grid[(int)object][y].status.equals("0") || grid[(int)object][y].status.equals("G")) {
					newNeighbor4.first = (int)object;
					newNeighbor4.second = y;
					newNeighbor4.status = grid[(int)object][y].status;
					stack.push(newNeighbor4);
					/*System.out.println("bottom is a neighbor. " + newNeighbor4.first + "," + newNeighbor4.second + " has been pushed to stack, now first to be popped: ");
				
					System.out.println("content of stack");
					for (int i = 0; i < stack.size(); i++) {
						System.out.println(stack.get(i).first + "," + stack.get(i).second);
					}*/
				}
			}
		}
		
		/*System.out.println("content of stack after checking for each neighbor:");
		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.get(i).first + "," + stack.get(i).second);
		}*/
		
		if (stack.size() == 0) {
			//for (int i = 0; i < 20; i++) {
				System.out.println("Path not found!!!");
			//}
		} else if (stack.peek().status.equals("G")) {
			//printGrid.printGrid(grid);
			System.out.println("Path found!!!");
		}
		
		//System.out.println();
		
		//pop stack and call dfs on node
		for (int i = 0; i < stack.size(); i++) {
			if (stack.peek().status.equals(("G"))) {
				//System.out.println("Path found!!!");
		//probably can change this^^^ to help us print out a path
				return grid;
			}
			//System.out.println(stack.peek().first + "," + stack.peek().second + " is about to be popped");
			grid = DFSsearch(grid,(Node)stack.pop());
		}
		
		return grid;
	}
}