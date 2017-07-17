/* Errors
 * 1. Goal node should be "0" (ProbBlockedCell.blockCells)
 * 2. Grid showing null pointer exception (Grid.makeGrid)
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
		
		System.out.println("Choose a search method...   (dfs, bfs, a*Euc, a*man)");
		String response = input.next();
		
		if (response.equals("dfs")) {
			Node node = new Node(grid[0][0].first, grid[0][0].second, grid[0][0].status);
			grid = DFSgraph.DFSsearch(grid,node);
			for (int i = 0; i < grid.length; i++) { 
				for (int j = 0; j < grid.length; j++) {
					System.out.print(grid[i][j].status + "   ");
				}
				System.out.println();
			}
			System.out.print("Done!");
			
		} else if (response.equals("bfs")) {
			Node node = new Node(grid[0][0].first, grid[0][0].second, grid[0][0].status);
			grid = BFSgraph.BFSsearch(grid, node);
			for (int i = 0; i < grid.length; i++) { 
				for (int j = 0; j < grid.length; j++) {
					System.out.print(grid[i][j].status + "   ");
				}
				System.out.println();
			}
			System.out.print("Done!");
			
		} else if (response.equals("a*euc")) {
			
		} else if (response.equals("a*man")) {
			
		} else {
			System.out.println("booo");
		}
	}
}