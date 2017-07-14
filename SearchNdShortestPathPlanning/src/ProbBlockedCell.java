import java.util.Random;

public class ProbBlockedCell {
	
	public static Node[][] blockCells(Node[][] grid, double probability) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (i+j != 0) {
					if (i*j != ((grid.length-1)*(grid.length-1))) {
						if (randomGen() <= probability) {	
							grid[i][j].status = "B";
						} 
					}
				}
				System.out.print(grid[i][j].status + "   ");
			}
			System.out.println();
		}
		return grid;
	}

	public static double randomGen() {
		double probability = Math.random();
		return probability;
	}
	
}
