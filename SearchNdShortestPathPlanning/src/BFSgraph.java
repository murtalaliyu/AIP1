import java.util.ArrayList;

public class BFSgraph {

	static ArrayList<Node> queue = new ArrayList<Node>();
	static ArrayList<Node> visited = new ArrayList<Node>();

	public static Node[][] BFSsearch(Node[][] grid, Node node) {
		
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
		
		//print updated path
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
		
		//check if there's no path
		if (queue.size() == 0) {
			System.out.println("Path not found!!!");
			return grid;
		} 
		
		//pop queue and recall bfs while queue is not empty
		for (int i = 0; i < queue.size(); i++) {
			grid = BFSsearch(grid,queue.remove(0));
		}
		
		return grid;
	}
}