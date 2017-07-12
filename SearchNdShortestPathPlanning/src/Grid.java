
public class Grid {

	public static Node[][] makeGrid(Node[][] grid) {
		Node node = new Node(0,"0");
		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				node = new Node(0,"0");
				node.serialNo = i+j+sum;
				node.status = "0";
				grid[i][j] = node;
				System.out.print(node.serialNo + "   ");
			}
			sum += grid.length-1;
			System.out.println();
		}
		return grid;
	}
}
