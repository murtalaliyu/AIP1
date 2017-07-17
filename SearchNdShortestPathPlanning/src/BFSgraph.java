/*
 * 1. Fix duplicate entries into queue
 * 2. stackOverFlow error as size of grid increases. probably has to do with bad recursive call at line 135
 */

import java.util.ArrayList;

public class BFSgraph {

	static ArrayList<Node> queue = new ArrayList<Node>();
	static ArrayList<Node> visited = new ArrayList<Node>();

	public static Node[][] BFSsearch(Node[][] grid, Node node) {
		
		if (node.status.equals("G")) {
			System.out.print("Goal found!!!");
			return grid;
		}
		
		visited.add(node);
		grid[node.first][node.second].status = "1";
		
		System.out.println();
		System.out.println();
		//print updated path
		System.out.println(grid[node.first][node.second].first + "" + grid[node.first][node.second].second + "," + grid[node.first][node.second].status + " has been added to the path. now searching for its neighbors");
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
					if (queue.contains(newNeighbor) == false) {
						queue.add(newNeighbor);
						System.out.println("left is a neighbor. " + newNeighbor.first + "" + newNeighbor.second + "," + newNeighbor.status + " has been added to the queue");
						
						System.out.println("content of queue");
						for (int i = 0; i < queue.size(); i++) {
							System.out.println(queue.get(i).first + "" +  queue.get(i).second + "," + queue.get(i).status);
						}
					}
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
					if (queue.contains(newNeighbor3) == false) {
						queue.add(newNeighbor3);
						System.out.println("top is a neighbor. " + newNeighbor3.first + "" + newNeighbor3.second + "," + newNeighbor.status + " has been added to the queue ");
					
						System.out.println("content of queue");
						for (int i = 0; i < queue.size(); i++) {
							System.out.println(queue.get(i).first + "" + queue.get(i).second + "," + queue.get(i).status);
						}
					}
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
					if (queue.contains(newNeighbor2) == false) {
						queue.add(newNeighbor2);
						System.out.println("right is a neighbor. " + newNeighbor2.first + "" + newNeighbor2.second + "," + newNeighbor.status + " has been added to the queue");
					
						System.out.println("content of queue");
						for (int i = 0; i < queue.size(); i++) {
							System.out.println(queue.get(i).first + "" + queue.get(i).second + "," + queue.get(i).status);
						}
					}
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
					if (queue.contains(newNeighbor4) == false) {
						queue.add(newNeighbor4);
						System.out.println("bottom is a neighbor. " + newNeighbor4.first + "" + newNeighbor4.second + "," + newNeighbor.status + " has been added to the queue: ");
					
						System.out.println("content of queue");
						for (int i = 0; i < queue.size(); i++) {
							System.out.println(queue.get(i).first + "" + queue.get(i).second + "," + queue.get(i).status);
						}
					}
				}
			}
		}
		
		System.out.println("content of queue after checking for each neighbor:");
		for (int i = 0; i < queue.size(); i++) {
			System.out.println(queue.get(i).first + "" + queue.get(i).second + "," + queue.get(i).status);
		}
		
		System.out.println();
		
		//pop queue and call bfs on node
		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i).status.equals(("G"))) { // POSSIBLE ERROR HERE
				System.out.println("Goal found!!!");
				return grid;
			}
			System.out.println(queue.get(i).first + "" + queue.get(i).second + "," + queue.get(i).status + " is about to be dequeued");
			grid = BFSsearch(grid,queue.remove(0)); //POSSIBLE ERROR HERE
		}
		
		return grid;
	}
}