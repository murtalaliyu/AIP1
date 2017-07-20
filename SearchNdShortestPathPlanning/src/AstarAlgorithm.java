import java.util.ArrayList;

public class AstarAlgorithm {
	
	static ArrayList<Node> queue = new ArrayList<Node>();
	static ArrayList<Node> visited = new ArrayList<Node>();
	
	public static Node[][] Start(Node[][] grid, Node node) {
		
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
		
		//System.out.println();
		//System.out.println();
		
		//print updated path and print grid
		//System.out.println(grid[node.first][node.second].first + "" + grid[node.first][node.second].second + "," + grid[node.first][node.second].status + " has been added to the path. now searching for its neighbors");
		//printGrid.printGrid(grid);
		
		//get this node's neighbors and add to stack
		queue = Neighbors.findRightNeighbor(grid, queue, node);
		queue = Neighbors.findBottomNeighbor(grid, queue, node);
		queue = Neighbors.findTopNeighbor(grid, queue, node);
		queue = Neighbors.findLeftNeighbor(grid, queue, node);
		
		//print queue after iteration i
		//System.out.println("content of queue after checking for each neighbor:");
		//Neighbors.printContentOfQueue(queue, node, "THIS IS THE END OF ADDING NEIGHBORS TO QUEUE");
		
		//System.out.println();
		
		//find and pick the newNode with the smallest FofN value in the queue
		int temp = 0;
		Node newNode = new Node(0,0,"0",1000,0);
		for (int j = 0; j < queue.size(); j++) {  
			if (queue.get(j).FofN < newNode.FofN) {
				newNode = queue.get(j);
				temp = queue.indexOf(queue.get(j));
			} else if (queue.get(j).FofN == newNode.FofN) {
				if ("a*euc".equals(Main.response)) {
					if (getEuclideanHofN(queue.get(j), grid[grid.length-1][grid.length-1]) < getEuclideanHofN(newNode, grid[grid.length-1][grid.length-1])) {
						newNode = queue.get(j);
						temp = queue.indexOf(queue.get(j));
					} 
				} else if ("a*man".equals(Main.response)) {
					if (getManhattanHofN(queue.get(j), grid[grid.length-1][grid.length-1]) < getManhattanHofN(newNode, grid[grid.length-1][grid.length-1])) {
						newNode = queue.get(j);
						temp = queue.indexOf(queue.get(j));
					} 
				} else if ("a*max".equals(Main.response)) {
					if (Questions.maxDistance(queue.get(j), grid[grid.length-1][grid.length-1]) < Questions.maxDistance(newNode, grid[grid.length-1][grid.length-1])) {
						newNode = queue.get(j);
						temp = queue.indexOf(queue.get(j));
					} 
				} else if ("a*min".equals(Main.response)) {
					if (Questions.minDistance(queue.get(j), grid[grid.length-1][grid.length-1]) < Questions.minDistance(newNode, grid[grid.length-1][grid.length-1])) {
						newNode = queue.get(j);
						temp = queue.indexOf(queue.get(j));
					} 
				} else if ("a*alphaWeightedCombination".equals(Main.response)) {
					if (Questions.alphaWeightedCombination(queue.get(j), grid[grid.length-1][grid.length-1], Main.alpha) < Questions.alphaWeightedCombination(newNode, grid[grid.length-1][grid.length-1], Main.alpha)) {
						newNode = queue.get(j);
						temp = queue.indexOf(queue.get(j));
					} 
				} else if ("a*betaNormDistance".equals(Main.response)) {
					if (Questions.betaNormDistance(queue.get(j), grid[grid.length-1][grid.length-1], Main.beta) < Questions.betaNormDistance(newNode, grid[grid.length-1][grid.length-1], Main.beta)) {
						newNode = queue.get(j);
						temp = queue.indexOf(queue.get(j));
					} 
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
		//System.out.println(newNode.first + "" + newNode.second + "," + newNode.status + " was removed");
		
		//re-pass the node
		grid = Start(grid, newNode);
		
		return grid;
	}

	public static double getManhattanHofN(Node n, Node goalNode) {
		
		double hOfn = Math.abs(n.first - goalNode.first) + Math.abs(n.second - goalNode.second);
		return hOfn;
	}
	
public static double getEuclideanHofN(Node n, Node goalNode) {
		
		double hOfn = Math.sqrt(((n.first - goalNode.first)*(n.first - goalNode.first)) + ((n.second - goalNode.second)*(n.second - goalNode.second)));
		return hOfn;
	}
}
