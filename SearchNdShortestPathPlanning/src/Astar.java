import java.util.*;

public class Astar {

	double fOfn = 0.0;
	double gOfn = 0.0;
	double hOfn = 0.0;
	
	int v_h_cost = 1;
	
	ArrayList<Node> openList = new ArrayList<Node>();
	ArrayList<Node> closedList = new ArrayList<Node>();
	
	public static Node[][] Astar(Node[][] grid, Node node) {
		
		return grid;
	}
	
	public static double getGofN(Node startNode, Node n) {
		
		double gOfn = (n.first + n.second) - (startNode.first + startNode.second);
		
		return gOfn;
	}
	
	public static double getHofN(Node n, Node goalNode) {
		
		double hOfn = 0;
		
		return hOfn;
	}
	
	public static double getFofN(double gOfn, double hOfn) {
		
		return gOfn + hOfn;
	}
}
