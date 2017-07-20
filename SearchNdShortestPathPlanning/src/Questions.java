import java.util.Random;

public class Questions {

	public static int questionTwo() {
		
		//pick a random cell size between 2 and 60
		Random r = new Random();
		
		int floor = 2, ceiling = 61;
		int number = r.nextInt((ceiling - floor) + floor);
		
		return number;
	}
	
	public static double maxDistance(Node n, Node goalNode) {
		
		double hOfn = Math.max(Math.sqrt(Math.pow(n.first-goalNode.first,2) + Math.pow(n.second-goalNode.second,2)), (double)Math.abs(n.first-goalNode.first) + Math.abs(n.second-goalNode.second));
		return hOfn;
	}
	
	public static double minDistance(Node n, Node goalNode) {
		
		double hOfn = Math.min(Math.sqrt(Math.pow(n.first-goalNode.first,2) + Math.pow(n.second-goalNode.second,2)), (double)Math.abs(n.first-goalNode.first) + Math.abs(n.second-goalNode.second));
		return hOfn;
	}
	
	public static double alphaWeightedCombination(Node n, Node goalNode, double alpha) {
		
		double hOfn = (alpha * Math.sqrt(Math.pow(n.first-goalNode.first,2) + Math.pow(n.second-goalNode.second,2))) + ((1-alpha)*((double)Math.abs(n.first-goalNode.first) + Math.abs(n.second-goalNode.second)));
		return hOfn;
	}
	
	public static double betaNormDistance(Node n, Node goalNode, double beta) {
		
		double hOfn = Math.pow((double)Math.pow(Math.abs(n.first-goalNode.first), beta) + Math.pow(Math.abs(n.second-goalNode.second), beta), (1/beta));
		return hOfn;
	}
	
	
}
