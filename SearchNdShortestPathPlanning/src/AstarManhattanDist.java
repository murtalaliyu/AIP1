import java.util.*;

public class AstarManhattanDist {
	
	static ArrayList<Node> queue = new ArrayList<Node>();
	static ArrayList<Node> visited = new ArrayList<Node>();
	
	public static Node[][] AstarMan(Node[][] grid, Node node) {
		
		//base case
		if (node.status.equals("G")) {
			System.out.println("Path found!!!");
			return grid;
		}  
		
		//add node to visited list
		visited.add(node);
		if (!("S".equals(node.status))) {
			grid[node.first][node.second].status = "1";
		}
		
		System.out.println();
		System.out.println();
		
		//print updated path and print grid
		System.out.println(grid[node.first][node.second].first + "" + grid[node.first][node.second].second + "," + grid[node.first][node.second].status + " has been added to the path. now searching for its neighbors");
		printGrid.printGrid(grid);
		
		//get this node's neighbors and add to stack
		queue = Neighbors.findBottomNeighbor(grid, queue, node);
		queue = Neighbors.findRightNeighbor(grid, queue, node);
		queue = Neighbors.findTopNeighbor(grid, queue, node);
		queue = Neighbors.findLeftNeighbor(grid, queue, node);
		
		//print queue after iteration i
		System.out.println("content of queue after checking for each neighbor:");
		Neighbors.printContentOfQueue(queue, node, "THIS IS THE END OF ADDING NEIGHBORS TO QUEUE");
		
		System.out.println();
		
		//find the newNode with the smallest FofN value
		int temp = 0;
		Node newNode = new Node(0,0,"0",1000,0);
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
		
		//check if there's no path
		if (queue.isEmpty()) {
			System.out.println("There is no path!");
			return grid;
		}
		
		//remove smallest FofN value
		queue.remove(temp);
		System.out.println(newNode.first + "" + newNode.second + "," + newNode.status + " was removed");
		
		//repass the node
		grid = AstarMan(grid, newNode);
		
		return grid;
	}

	public static double getHeuristic(Node n, Node goalNode) {
		
		double hOfn = Math.abs(n.first - goalNode.first) + Math.abs(n.second - goalNode.second);

		return hOfn;
	}
}
