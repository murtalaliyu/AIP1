import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int answer = 0;
		System.out.println("Enter size of grid... (INTEGERS ONLY!!!)");
		answer = input.nextInt();
				
		Node grid = new Node(0, "");
		Grid.makeGrid(grid, answer);
		System.out.println();
		
		/*System.out.println("Now, enter a p value... (0.0 < p < 1.0)");
		double ans = input.nextDouble();
		grid = ProbBlockedCell.blockCells(grid, ans);
		
		System.out.println("Choose a search method...   (DFS, BFS, A*Euc, A*Man)");
		String response = input.next();
		if (response.equals("DFS")) {
			DFSgraph.DFSsearch(grid,0,0);
		} else {
			System.out.println("you suck!");
		}*/
	}
}
