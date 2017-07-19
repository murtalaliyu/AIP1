/*
 * 1. bfs sometimes returns "Path not found!!!" even if there is a clear path taken
 * 2. merge dfs stack with Neighbors class
 */

import java.util.Scanner;

public class Main {
	
	static String response = "";
	
	public static void main(String[] args) {
		
		Object quit = null;
		Scanner input = new Scanner(System.in);
		int answer = 0;
		
		try {
			do {
				//ask to quit
				System.out.println("." + '\n' + "."  + '\n' + ".");
				System.out.println("In order to quit; press q, then press enter/return");
				System.out.println("." + '\n' + "."  + '\n' + ".");
				
				//get size of grid
				System.out.println("Enter size of grid... (INTEGERS ONLY!!!)");
				answer = input.nextInt();
						
				//initialize grid variable
				Node[][] grid = new Node[answer][answer];
				Grid.makeGrid(grid);
				
				//get probability of a cell getting blocked
				System.out.println("Now, enter a p value... (0.0 < p < 1.0)");
				double ans = input.nextDouble();
				grid = ProbBlockedCell.blockCells(grid, ans);
				
				//choose a VALID search method
				System.out.println("Choose a search method...   (dfs, bfs, a*euc, a*man)");
				response = input.next();
			
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
			} while ((Integer)answer instanceof Integer);
		} catch (Exception e) {
			System.out.print("Goodbye...");
		}
	}
}