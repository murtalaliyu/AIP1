/*
 * 1. Might have to add FofN checker
 */

import java.util.ArrayList;

public class Contains {

	public static boolean contains(ArrayList<Node> queue, Node node) {
		
		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i).first == node.first) {
				if (queue.get(i).second == node.second) {
					return true;
				}
			}
		}
		return false;
	}
}
