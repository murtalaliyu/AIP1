/*
 * 1. merge dfs stack with Neighbors class
 */

import java.util.Scanner;

public class Main {
	
	static String response = "";
	static double alpha = 0, beta = 0;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int answer = 0;
		
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
		System.out.println("Choose a search method...   (dfs, bfs, a*euc, a*man, a*max, a*min, a*alphaWeightedCombination, a*betaNormDistance)");
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
			System.out.println("Number of nodes expanded: " + Neighbors.nodesExpanded);
			
		} else if (response.equals("a*man")) {
			grid = AstarManhattanDist.AstarMan(grid, node);
			printGrid.printGrid(grid);
			System.out.println("Number of nodes expanded: " + Neighbors.nodesExpanded);
			
		} else if (response.equals("a*max")) {
			grid = AstarManhattanDist.AstarMan(grid, node);
			printGrid.printGrid(grid);
			System.out.println("Number of nodes expanded: " + Neighbors.nodesExpanded);
			
		} else if (response.equals("a*min")) {
			grid = AstarManhattanDist.AstarMan(grid, node);
			printGrid.printGrid(grid);
			System.out.println("Number of nodes expanded: " + Neighbors.nodesExpanded);
			
		} else if (response.equals("a*alphaWeightedCombination")) {
			System.out.println("Enter an alpha value... (0 < alpha < 1)");
			alpha = input.nextDouble();
			grid = AstarManhattanDist.AstarMan(grid, node);
			printGrid.printGrid(grid);
			System.out.println("Number of nodes expanded: " + Neighbors.nodesExpanded);
			
			
		} else if (response.equals("a*betaNormDistance")) {
			System.out.println("Enter a beta value... (1 < beta < 2)");
			beta = input.nextDouble();
			grid = AstarManhattanDist.AstarMan(grid, node);
			printGrid.printGrid(grid);
			System.out.println("Number of nodes expanded: " + Neighbors.nodesExpanded);
			
		} else {
			System.out.println("booo");
		}
	}
}