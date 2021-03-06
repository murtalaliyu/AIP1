import java.util.Random;

public class ProbBlockedCell {
	
	public static Node[][] blockCells(Node[][] grid, double probability, int length) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
			    if (i+j == 0) {
			        grid[i][j].status = "S";
                }
				else if (i+j != 0) {
					if (i*j != ((length-1)*(length-1))) {
						if (randomGen() <= probability) {	
							grid[i][j].status = "B";
						} 
					}
					else if (i*j == ((length-1)*(length-1))) {
					    grid[i][j].status = "G";
                    }
				}
				System.out.print(grid[i][j].status + "   ");
				//System.out.println(i+j);
				//System.out.println((length-1)+(length-1));
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
