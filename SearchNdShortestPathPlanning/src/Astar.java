public class Astar {

	double fOfn = 0.0;
	double gOfn = 0.0;
	double hOfn = 0.0;
	
	int v_h_cost = 1;
	
	public static double getGofN(Node startNode, Node n) {
		
		double gOfn = Math.sqrt(((startNode.first - n.first)*(startNode.first - n.first)) + ((startNode.second - n.second)*(startNode.second - n.second)));
		
		return gOfn;
	}
	
	public static double getFofN(double gOfn, double hOfn) {
		
		return gOfn + hOfn;
	}
}
