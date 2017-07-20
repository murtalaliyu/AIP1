import java.util.*;

public class Neighbors {
	
	static int nodesExpanded = 0;

	//get this node's neighbors and add to queue (stack not functional)
	static int x = 0;
	static int y = 0;
	static Object object = new Object();
	
	public static ArrayList<Node> findLeftNeighbor(Node[][] grid, ArrayList<Node> queue, Node node) {

		x = node.first;
		y = node.second;
		double gOfn = 0, hOfn = 0, fOfn = 0;
		Node newNeighbor = new Node(0,0,"0",0,0);
		
		object = y-1;
		if (object instanceof Integer) {
			if ((int)object != -1) {
				if (grid[x][(int)object].status.equals("0") || grid[x][(int)object].status.equals("G") || grid[(int)object][y].status.equals("S")) {
					newNeighbor.first = x;
					newNeighbor.second = (int)object;
					newNeighbor.status = grid[x][(int)object].status;
					if (Contains.contains(queue,newNeighbor) == false) {
						if ("a*euc".equals(Main.response)) {
							newNeighbor.GofN = newNeighbor.GofN + 1;
							gOfn = newNeighbor.GofN;
							hOfn = AstarAlgorithm.getEuclideanHofN(newNeighbor, grid[grid.length-1][grid.length-1]);
						} else if ("a*man".equals(Main.response)) {
							newNeighbor.GofN = newNeighbor.GofN + 1;
							gOfn = newNeighbor.GofN;
							hOfn = AstarAlgorithm.getManhattanHofN(newNeighbor, grid[grid.length-1][grid.length-1]);
						} else if ("a*max".equals(Main.response)) {
							newNeighbor.GofN = newNeighbor.GofN + 1;
							gOfn = newNeighbor.GofN;
							hOfn = Questions.maxDistance(newNeighbor, grid[grid.length-1][grid.length-1]);
						} else if ("a*min".equals(Main.response)) {
							newNeighbor.GofN = newNeighbor.GofN + 1;
							gOfn = newNeighbor.GofN;
							hOfn = Questions.minDistance(newNeighbor, grid[grid.length-1][grid.length-1]);
						} else if ("a*alphaWeightedCombination".equals(Main.response)) {
							newNeighbor.GofN = newNeighbor.GofN + 1;
							gOfn = newNeighbor.GofN;
							hOfn = Questions.alphaWeightedCombination(newNeighbor, grid[grid.length-1][grid.length-1], Main.alpha);
						} else if ("a*betaNormDistance".equals(Main.response)) {
							newNeighbor.GofN = newNeighbor.GofN + 1;
							gOfn = newNeighbor.GofN;
							hOfn = Questions.betaNormDistance(newNeighbor, grid[grid.length-1][grid.length-1], Main.beta);
						}
						fOfn = Astar.getFofN(gOfn, hOfn);
						newNeighbor.FofN = fOfn;
						queue.add(newNeighbor);
						
						nodesExpanded += 1;
						//print content of queue after adding neighbor
						//printContentOfQueue(queue, node, "left");
					}
				}
			}
		} 
		return queue;
	}
	
	public static ArrayList<Node> findTopNeighbor(Node[][] grid, ArrayList<Node> queue, Node node) {
		
		x = node.first;
		y = node.second;
		double gOfn = 0, hOfn = 0, fOfn = 0;
		Node newNeighbor3 = new Node(0,0,"0",0,0);
		
		object = x-1;
		if (object instanceof Integer == true) {
			if ((int)object != -1) { 
				if (grid[(int)object][y].status.equals("0") || grid[(int)object][y].status.equals("G") || grid[(int)object][y].status.equals("S")) {
					newNeighbor3.first = (int)object;
					newNeighbor3.second = y;
					newNeighbor3.status = grid[(int)object][y].status;
					if (Contains.contains(queue,newNeighbor3) == false) {
						if ("a*euc".equals(Main.response)) {
							newNeighbor3.GofN = newNeighbor3.GofN + 1;
							gOfn = newNeighbor3.GofN;
							hOfn = AstarAlgorithm.getEuclideanHofN(newNeighbor3, grid[grid.length-1][grid.length-1]);
						} else if ("a*man".equals(Main.response)) {
							newNeighbor3.GofN = newNeighbor3.GofN + 1;
							gOfn = newNeighbor3.GofN;
							hOfn = AstarAlgorithm.getManhattanHofN(newNeighbor3, grid[grid.length-1][grid.length-1]);
						} else if ("a*max".equals(Main.response)) {
							newNeighbor3.GofN = newNeighbor3.GofN + 1;
							gOfn = newNeighbor3.GofN;
							hOfn = Questions.maxDistance(newNeighbor3, grid[grid.length-1][grid.length-1]);
						} else if ("a*min".equals(Main.response)) {
							newNeighbor3.GofN = newNeighbor3.GofN + 1;
							gOfn = newNeighbor3.GofN;
							hOfn = Questions.minDistance(newNeighbor3, grid[grid.length-1][grid.length-1]);
						} else if ("a*alphaWeightedCombination".equals(Main.response)) {
							newNeighbor3.GofN = newNeighbor3.GofN + 1;
							gOfn = newNeighbor3.GofN;
							hOfn = Questions.alphaWeightedCombination(newNeighbor3, grid[grid.length-1][grid.length-1], Main.alpha);
						} else if ("a*betaNormDistance".equals(Main.response)) {
							newNeighbor3.GofN = newNeighbor3.GofN + 1;
							gOfn = newNeighbor3.GofN;
							hOfn = Questions.betaNormDistance(newNeighbor3, grid[grid.length-1][grid.length-1], Main.beta);
						}
						fOfn = Astar.getFofN(gOfn, hOfn);
						newNeighbor3.FofN = fOfn;
						queue.add(newNeighbor3);

						nodesExpanded += 1;
						//print content of queue after adding neighbor
						//printContentOfQueue(queue, node, "top");
					}
				}
			}
		}
		return queue;
	}
	
	public static ArrayList<Node> findRightNeighbor(Node[][] grid, ArrayList<Node> queue, Node node) {
		
		x = node.first;
		y = node.second;
		double gOfn = 0, hOfn = 0, fOfn = 0;
		Node newNeighbor2 = new Node(0,0,"0",0,0);
		
		object = y+1;
		if (object instanceof Integer == true) {
			if ((int)object != grid.length) {
				if (grid[x][(int)object].status.equals("0") || grid[x][(int)object].status.equals("G") || grid[(int)object][y].status.equals("S")) {
					newNeighbor2.first = x;
					newNeighbor2.second = (int)object;
					newNeighbor2.status = grid[x][(int)object].status;
					if (Contains.contains(queue,newNeighbor2) == false) {
						if ("a*euc".equals(Main.response)) {
							newNeighbor2.GofN = newNeighbor2.GofN + 1;
							gOfn = newNeighbor2.GofN;
							hOfn = AstarAlgorithm.getEuclideanHofN(newNeighbor2, grid[grid.length-1][grid.length-1]);
						} else if ("a*man".equals(Main.response)) {
							newNeighbor2.GofN = newNeighbor2.GofN + 1;
							gOfn = newNeighbor2.GofN;
							hOfn = AstarAlgorithm.getManhattanHofN(newNeighbor2, grid[grid.length-1][grid.length-1]);
						} else if ("a*max".equals(Main.response)) {
							newNeighbor2.GofN = newNeighbor2.GofN + 1;
							gOfn = newNeighbor2.GofN;
							hOfn = Questions.maxDistance(newNeighbor2, grid[grid.length-1][grid.length-1]);
						} else if ("a*min".equals(Main.response)) {
							newNeighbor2.GofN = newNeighbor2.GofN + 1;
							gOfn = newNeighbor2.GofN;
							hOfn = Questions.minDistance(newNeighbor2, grid[grid.length-1][grid.length-1]);
						} else if ("a*alphaWeightedCombination".equals(Main.response)) {
							newNeighbor2.GofN = newNeighbor2.GofN + 1;
							gOfn = newNeighbor2.GofN;
							hOfn = Questions.alphaWeightedCombination(newNeighbor2, grid[grid.length-1][grid.length-1], Main.alpha);
						} else if ("a*betaNormDistance".equals(Main.response)) {
							newNeighbor2.GofN = newNeighbor2.GofN + 1;
							gOfn = newNeighbor2.GofN;
							hOfn = Questions.betaNormDistance(newNeighbor2, grid[grid.length-1][grid.length-1], Main.beta);
						}
						fOfn = Astar.getFofN(gOfn, hOfn);
						newNeighbor2.FofN = fOfn;
						queue.add(newNeighbor2);

						nodesExpanded += 1;
						//print content of queue after adding neighbor
						//printContentOfQueue(queue, node, "right");
					}
				}
			}
		}
		return queue;
	}
	
	public static ArrayList<Node> findBottomNeighbor(Node[][] grid, ArrayList<Node> queue, Node node) {
		
		x = node.first;
		y = node.second;
		double gOfn = 0, hOfn = 0, fOfn = 0;
		Node newNeighbor4 = new Node(0,0,"0",0,0);
		
		object = x+1;
		if (object instanceof Integer == true) {
			if ((int)object != grid.length) {
				if (grid[(int)object][y].status.equals("0") || grid[(int)object][y].status.equals("G") || grid[(int)object][y].status.equals("S")) {
					newNeighbor4.first = (int)object;
					newNeighbor4.second = y;
					newNeighbor4.status = grid[(int)object][y].status;
					if (Contains.contains(queue,newNeighbor4) == false) {
						if ("a*euc".equals(Main.response)) {
							newNeighbor4.GofN = newNeighbor4.GofN + 1;
							gOfn = newNeighbor4.GofN;
							hOfn = AstarAlgorithm.getEuclideanHofN(newNeighbor4, grid[grid.length-1][grid.length-1]);
						} else if ("a*man".equals(Main.response)) {
							newNeighbor4.GofN = newNeighbor4.GofN + 1;
							gOfn = newNeighbor4.GofN;
							hOfn = AstarAlgorithm.getManhattanHofN(newNeighbor4, grid[grid.length-1][grid.length-1]);
						} else if ("a*max".equals(Main.response)) {
							newNeighbor4.GofN = newNeighbor4.GofN + 1;
							gOfn = newNeighbor4.GofN;
							hOfn = Questions.maxDistance(newNeighbor4, grid[grid.length-1][grid.length-1]);
						} else if ("a*min".equals(Main.response)) {
							newNeighbor4.GofN = newNeighbor4.GofN + 1;
							gOfn = newNeighbor4.GofN;
							hOfn = Questions.minDistance(newNeighbor4, grid[grid.length-1][grid.length-1]);
						} else if ("a*alphaWeightedCombination".equals(Main.response)) {
							newNeighbor4.GofN = newNeighbor4.GofN + 1;
							gOfn = newNeighbor4.GofN;
							hOfn = Questions.alphaWeightedCombination(newNeighbor4, grid[grid.length-1][grid.length-1], Main.alpha);
						} else if ("a*betaNormDistance".equals(Main.response)) {
							newNeighbor4.GofN = newNeighbor4.GofN + 1;
							gOfn = newNeighbor4.GofN;
							hOfn = Questions.betaNormDistance(newNeighbor4, grid[grid.length-1][grid.length-1], Main.beta);
						}
						fOfn = Astar.getFofN(gOfn, hOfn);
						newNeighbor4.FofN = fOfn;
						queue.add(newNeighbor4);

						nodesExpanded += 1;
						//print content of queue after adding neighbor
						//printContentOfQueue(queue, node, "bottom");
					}
				}
			}
		}
		return queue;
	}
	
	public static void printContentOfQueue(ArrayList<Node> queue, Node node, String neighbor) {

		System.out.println();
	
		System.out.println("size of queue: " + queue.size());
		for (int i = 0; i < queue.size(); i++) {
			System.out.println(queue.get(i).first + "," +  queue.get(i).second + "," + queue.get(i).status);
		}
	}
	
	public static void printContentOfStack(Stack<Node> stack) {
		
		System.out.println();
		
		System.out.println("size of stack: " + stack.size());
		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.get(i).first + "," + stack.get(i).second + "," + stack.get(i).status);
		}
	}
}
