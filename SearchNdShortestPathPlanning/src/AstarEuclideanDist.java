import java.util.*;

public class AstarEuclideanDist {
	
	static ArrayList<Node> queue = new ArrayList<Node>();
	static ArrayList<Node> visited = new ArrayList<Node>();

	public static Node[][] AstarEuc(Node[][] grid, Node node) {
		
		if (node.status.equals("G")) {
			System.out.println("Path found!!!");
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
		Node newNeighbor = new Node(0,0,"0",0);
		Node newNeighbor2 = new Node(0,0,"0",0);
		Node newNeighbor3 = new Node(0,0,"0",0);
		Node newNeighbor4 = new Node(0,0,"0",0);
		Object object = new Object();
		
		object = y-1;
		if (object instanceof Integer) {
			if ((int)object != -1) {
				if (grid[x][(int)object].status.equals("0") || grid[x][(int)object].status.equals("G")) {
					newNeighbor.first = x;
					newNeighbor.second = (int)object;
					newNeighbor.status = grid[x][(int)object].status;
					if (Contains.contains(queue,newNeighbor) == false) {
						double gOfn = Astar.getGofN(grid[0][0], newNeighbor);
						double hOfn = getHeuristic(newNeighbor, grid[grid.length-1][grid.length-1]);
						double fOfn = Astar.getFofN(gOfn, hOfn);
						newNeighbor.FofN = fOfn;
						queue.add(newNeighbor);
						System.out.println("left is a neighbor. " + newNeighbor.first + "" + newNeighbor.second + "," + newNeighbor.status + "," + newNeighbor.FofN + " has been added to the queue");
						
						System.out.println("size of queue: " + queue.size());
						/*for (int i = 0; i < queue.size(); i++) {
							System.out.println(queue.get(i).first + "" +  queue.get(i).second + "," + queue.get(i).status);
						}*/
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
					if (Contains.contains(queue,newNeighbor3) == false) {
						double gOfn = Astar.getGofN(grid[0][0], newNeighbor3);
						double hOfn = getHeuristic(newNeighbor3, grid[grid.length-1][grid.length-1]);
						double fOfn = Astar.getFofN(gOfn, hOfn);
						newNeighbor.FofN = fOfn;
						queue.add(newNeighbor3);
						System.out.println("top is a neighbor. " + newNeighbor3.first + "" + newNeighbor3.second + "," + newNeighbor3.status + "," + newNeighbor3.FofN + " has been added to the queue ");
					
						System.out.println("size of queue: " + queue.size());
						/*for (int i = 0; i < queue.size(); i++) {
							System.out.println(queue.get(i).first + "" +  queue.get(i).second + "," + queue.get(i).status);
						}*/
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
					if (Contains.contains(queue,newNeighbor2) == false) {
						double gOfn = Astar.getGofN(grid[0][0], newNeighbor2);
						double hOfn = getHeuristic(newNeighbor2, grid[grid.length-1][grid.length-1]);
						double fOfn = Astar.getFofN(gOfn, hOfn);
						newNeighbor2.FofN = fOfn;
						queue.add(newNeighbor2);
						System.out.println("right is a neighbor. " + newNeighbor2.first + "" + newNeighbor2.second + "," + newNeighbor2.status + "," + newNeighbor2.FofN + " has been added to the queue");
					
						System.out.println("size of queue: " + queue.size());
						/*for (int i = 0; i < queue.size(); i++) {
							System.out.println(queue.get(i).first + "" +  queue.get(i).second + "," + queue.get(i).status);
						}*/
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
					if (Contains.contains(queue,newNeighbor4) == false) {
						double gOfn = Astar.getGofN(grid[0][0], newNeighbor4);
						double hOfn = getHeuristic(newNeighbor4, grid[grid.length-1][grid.length-1]);
						double fOfn = Astar.getFofN(gOfn, hOfn);
						newNeighbor4.FofN = fOfn;
						queue.add(newNeighbor4);
						System.out.println("bottom is a neighbor. " + newNeighbor4.first + "" + newNeighbor4.second + "," + newNeighbor4.status + "," + newNeighbor4.FofN + " has been added to the queue: ");
					
						System.out.println("size of queue: " + queue.size());
						/*for (int i = 0; i < queue.size(); i++) {
							System.out.println(queue.get(i).first + "" +  queue.get(i).second + "," + queue.get(i).status);
						}*/
					}
				}
			}
		}
		
		System.out.println("content of queue after checking for each neighbor:");
		for (int i = 0; i < queue.size(); i++) {
			System.out.println(queue.get(i).first + "" + queue.get(i).second + "," + queue.get(i).status + "," + queue.get(i).FofN);
		}
		
		System.out.println();
		
		//pop queue and call bfs on node
		Node newNode = new Node(0,0,"0",1000);
		int temp = 0;
		for (int j = 0; j < queue.size(); j++) {  
			if (queue.get(j).FofN < newNode.FofN) {
				newNode = queue.get(j);
				temp = queue.indexOf(queue.get(j));
			} else if (queue.get(j).FofN == newNode.FofN) {
				if (getHeuristic(queue.get(j), grid[grid.length-1][grid.length-1]) < getHeuristic(newNode, grid[grid.length-1][grid.length-1])) {
					newNode = queue.get(j);
					temp = queue.indexOf(queue.get(j));
				} 
			}
		}
		
		if (queue.isEmpty()) {
			System.out.println("There is no path!");
			return grid;
		}
		
		queue.remove(temp);
		System.out.println(newNode.first + "" + newNode.second + "," + newNode.status + " was removed");
		
		grid = AstarEuc(grid, newNode); 
		
		/*for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i).status.equals(("G"))) { 
				System.out.println("Goal found!!!");
				return grid;
			}
			System.out.println(queue.get(i).first + "" + queue.get(i).second + "," + queue.get(i).status + " is about to be dequeued");
			
			grid = AstarEuc(grid, newNode); 
		}*/
		
		return grid;
		
	}
	
	public static double getHeuristic(Node n, Node goalNode) {
		
		double hOfn = Math.sqrt(((n.first - goalNode.first)*(n.first - goalNode.first)) + ((n.second - goalNode.second)*(n.second - goalNode.second)));
		
		return hOfn;
	}
}
