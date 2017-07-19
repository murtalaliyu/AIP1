public class Grid {

	public static Node[][] makeGrid(Node[][] grid) {
		Node node = new Node(0,0,"0",0,0);
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (i+j == 0) {
					node = new Node(0,0,"0",0,0);
					node.first = i;
					node.second = j;
					node.status = "S";
					node.FofN = 0;
					node.GofN = 0;
					grid[i][j] = node;
				} else if (i*j == ((grid.length-1)*(grid.length-1))) {
					node = new Node(0,0,"0",0,0);
					node.first = i;
					node.second = j;
					node.status = "G";
					node.FofN = 0;
					node.GofN = 0;
					grid[i][j] = node;
                }
				else {	
				node = new Node(0,0,"0",0,0);
				node.first = i;
				node.second = j;
				node.status = "0";
				node.FofN = 0;
				node.GofN = 0;
				grid[i][j] = node;
				}
			}
		}
		return grid;
	}
}
