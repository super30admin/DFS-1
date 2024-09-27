
// Time Complexity :O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class FloodFill {

	private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		if (image == null || image.length == 0 || image[sr][sc] == newColor)
			return image;

		int m = image.length;
		int n = image[0].length;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		int color = image[sr][sc];
		image[sr][sc] = newColor;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int[] dir : dirs) {
				int r = curr[0] + dir[0];
				int c = curr[1] + dir[1];

				if (r >= 0 && c >= 0 && r < m && c < n && image[r][c] == color) {
					image[r][c] = newColor;
					q.add(new int[] { r, c });
				}

			}

		}

		return image;
	}

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		FloodFill f = new FloodFill();
		f.floodFill(image, 1, 1, 2);

	}

}
