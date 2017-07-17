public class Grid {

	public static Node[][] makeGrid(Node[][] grid) {
		Node node = new Node(0,0,"0");
		int sum = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (i*j == ((grid.length-1)*(grid.length-1))) {
					node = new Node(0,0,"0");
					node.first = i;
					node.second = j;
					node.status = "G";
					grid[i][j] = node;
					//System.out.print(node.status + "   ");
                }
				else {	
				node = new Node(0,0,"0");
				node.first = i;
				node.second = j;
				node.status = "0";
				grid[i][j] = node;
				//System.out.print(node.first + "," + node.second + "   ");
				//System.out.print(node.status + "   ");
				}
			}
			sum += grid.length-1;
			//System.out.println();
		}
		return grid;
	}
}
