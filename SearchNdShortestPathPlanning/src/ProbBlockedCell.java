import java.util.Random;

public class ProbBlockedCell {
	
	public static Node blockCells(Node grid, double probability, int length) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i+j != 0) {
					if (i*j != ((length-1)*(length-1))) {
						if (randomGen() <= probability) {	
							grid.status = "B";
						} 
					}
				}
				System.out.print(grid.status + "   ");
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
