// Time Complexity : O(N) //all the nodes will be visited
// Space Complexity : O(N) //queue will have only one level elements that is max n/2 at leaf level.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Find the elements with nr,nc and add it to queue and update value to new color.
 * 2. then traverse and find all the 4 side elements which value is previous value.
 * 3. when adjacent 1 is found mark it to newcolor as it is already visited and add it to queue.
 * 4. it is BFS approach.
 */

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillBFS {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int actValue = image[sr][sc];
		if(actValue==newColor) return image;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(sr);
		queue.add(sc);
		image[sr][sc] = newColor;

		int[][] adjArr = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int k = 0; k < size; k = k + 2) {
				int i = queue.poll();
				int j = queue.poll();

				for (int m = 0; m < adjArr.length; m++) {
					int nr = i + adjArr[m][0];
					int nc = j + adjArr[m][1];

					if (nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && image[nr][nc] == actValue) {
						image[nr][nc] = newColor;
						queue.add(nr);
						queue.add(nc);
					}
				}
			}
		}
		return image;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 0, 0, 0, }, { 0, 1, 1 } };
		new FloodFillBFS().floodFill(arr, 1, 1, 1);
	}
}
