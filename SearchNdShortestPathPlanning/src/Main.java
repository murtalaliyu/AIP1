import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int answer = 0;
		System.out.println("Enter size of grid... (INTEGERS ONLY!!!)");
		answer = input.nextInt();
				
		String[][] grid = new String[answer][answer];
		Grid.makeGrid(grid, answer);
		System.out.println();
		
		System.out.println("Now, enter a p value... (0.0 < p < 1.0)");
		double ans = input.nextDouble();
		ProbBlockedCell.blockCells(grid, ans);
	}
}
