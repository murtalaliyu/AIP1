/* Errors
 * 
 */

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int answer = 0;
		System.out.println("Enter size of grid... (INTEGERS ONLY!!!)");
		answer = input.nextInt();
				
		Node[][] grid = new Node[answer][answer];
		Grid.makeGrid(grid);
		
		System.out.println();
		
		System.out.println("Now, enter a p value... (0.0 < p < 1.0)");
		double ans = input.nextDouble();
		grid = ProbBlockedCell.blockCells(grid, ans);
		
		System.out.println("Choose a search method...   (dfs, bfs, a*, a*euc, a*man)");
		String response = input.next();
	
		Node node = new Node(grid[0][0].first, grid[0][0].second, grid[0][0].status, 0,0);
		
		if (response.equals("dfs")) {
			grid = DFSgraph.DFSsearch(grid,node);
			printGrid.printGrid(grid);
			
		} else if (response.equals("bfs")) {
			grid = BFSgraph.BFSsearch(grid, node);
			printGrid.printGrid(grid);
			
		} else if (response.equals("a*euc")) {
			grid = AstarEuclideanDist.AstarEuc(grid, node);
			printGrid.printGrid(grid);
			
		} else if (response.equals("a*man")) {
			grid = AstarManhattanDist.AstarMan(grid, node);
			printGrid.printGrid(grid);
			
		} else {
			System.out.println("booo");
		}
	}
}