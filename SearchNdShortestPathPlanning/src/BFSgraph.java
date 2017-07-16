/*
 * Needs hella work
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSgraph {

	static LinkedList<Node> queue = new LinkedList<Node>();
	static ArrayList<Node> visited = new ArrayList<Node>();

	public static Node[][] BFSsearch(Node[][] grid, Node node) {
		
		if (node.status == "G") {
			return grid;
		}
		
		visited.add(node);
		grid[node.first][node.second].status = "1";
		
		System.out.println();
		System.out.println();
		//print updated path
		System.out.println(grid[node.first][node.second].first + "," + grid[node.first][node.second].second + " has been added to the path. now searching for its neighbors");
		System.out.println("updated path:");
		for (int i = 0; i < grid.length; i++) { 
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j].status + "   ");
			}
			System.out.println();
		}
		
		//get this node's neighbors and add to stack
		int x = node.first;
		int y = node.second;
		Node newNeighbor = new Node(0,0,"0");
		Object object = new Object();
		
		object = y-1;
		if (object instanceof Integer == true) {
			if ((int)object != -1) {
				if (grid[x][(int)object].status == "0") {
					newNeighbor.first = x;
					newNeighbor.second = (int)object;
					newNeighbor.status = grid[x][(int)object].status;
					queue.add(newNeighbor);
					System.out.println("left is a neighbor. " + newNeighbor.first + "," + newNeighbor.second + " has been enqueued ");
				
					/*System.out.println("content of stack");
					for (int i = 0; i < queue.size(); i++) {
						System.out.println(queue.);
					}*/
				}
			}
		} 
		object = y+1;
		if (object instanceof Integer == true) {
			if ((int)object != grid.length) {
				if (grid[x][(int)object].status == "0") {
					newNeighbor.first = x;
					newNeighbor.second = (int)object;
					newNeighbor.status = grid[x][(int)object].status;
					queue.add(newNeighbor);
					System.out.println("right is a neighbor. " + newNeighbor.first + "," + newNeighbor.second + " has been enqueued ");
				
					/*System.out.println("content of stack");
					for (int i = 0; i < stack.size(); i++) {
						System.out.println(stack.get(i).first + "," + stack.get(i).second);
					}*/
				}
			}
		}
		object = x-1;
		if (object instanceof Integer == true) {
			if ((int)object != -1) { 
				if (grid[(int)object][y].status == "0") {
					newNeighbor.first = (int)object;
					newNeighbor.second = y;
					newNeighbor.status = grid[(int)object][y].status;
					queue.add(newNeighbor);
					System.out.println("top is a neighbor. " + newNeighbor.first + "," + newNeighbor.second + " has been enqueued ");
				
					/*System.out.println("content of stack");
					for (int i = 0; i < stack.size(); i++) {
						System.out.println(stack.get(i).first + "," + stack.get(i).second);
					}*/
				}
			}
		}
		object = x+1;
		if (object instanceof Integer == true) {
			if ((int)object != grid.length) {
				if (grid[(int)object][y].status == "0") {
					newNeighbor.first = (int)object;
					newNeighbor.second = y;
					newNeighbor.status = grid[(int)object][y].status;
					queue.add(newNeighbor);
					System.out.println("bottom is a neighbor. " + newNeighbor.first + "," + newNeighbor.second + " has been enqueued ");
				
					/*System.out.println("content of stack");
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
		
		System.out.println();
		
		//pop stack and call dfs on node
		for (int i = 0; i < queue.size(); i++) {
			//System.out.println(stack.peek().first + "," + stack.peek().second + " is about to be dequeued");
			Node n = queue.getFirst();
			queue.remove();
			grid = BFSsearch(grid,n);
		}
		
		return grid;
	}
}
