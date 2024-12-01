// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	class Solution {
		public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
			if (image == null || image.length == 0 || image[sr][sc] == newColor)
				return image;
			int color = image[sr][sc];
			image[sr][sc] = newColor;
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { sr, sc });
			int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			while (!q.isEmpty()) {
				int[] curr = q.poll();
				for (int[] dir : dirs) {
					int r = curr[0] + dir[0];
					int c = curr[1] + dir[1];
					if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color) {
						image[r][c] = newColor;
						q.add(new int[] { r, c });
					}
				}
			}
			return image;
		}
	}
}
