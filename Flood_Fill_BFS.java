
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Flood_Fill_BFS {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image == null || image[sr][sc] == newColor)
			return image;
		Queue<int[]> q = new LinkedList<>();
		int color = image[sr][sc];
		image[sr][sc] = newColor;
		q.add(new int[] { sr, sc });
		int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!q.isEmpty()) {
			int curr[] = q.poll();
			for (int dir[] : directions) {
				int r = dir[0] + curr[0];
				int c = dir[1] + curr[1];
				if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color) {
					image[r][c] = newColor;
					q.add(new int[] { r, c });
				}
			}
		}
		return image;
	}
}