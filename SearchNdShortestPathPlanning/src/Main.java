import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int answer = 0;
		//do {
			System.out.println("Enter size of grid... (ONLY INTEGERS!!!)");
			answer = input.nextInt();
		//} while (answer != (int)answer);
				
		String[][] grid = new String[answer][answer];
		
		Grid.makeGrid(grid, answer);
	}
}
