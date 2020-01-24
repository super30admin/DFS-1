//Time complexity is O(m*n) i.e row*column.
//Space complexity is O(m*n) i.e row*column elements in recursive stack.
//This solution is submitted on leetcode

public class BigN62FloodFillImageUsingDFS {
	class Solution {
		int oldColor = -1;
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
			// edge case
			if (image.length == 0 || image == null || image[sr][sc] == newColor)
				return image;
			oldColor = image[sr][sc];
			dfs(image, sr, sc, newColor);
			return image;
		}
		private void dfs(int[][] image, int sr, int sc, int newColor) {
			// base case
			if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor)
				return;
			// logic
			image[sr][sc] = newColor;
			for (int[] dir : dirs) {
				int r = sr + dir[0];
				int c = sc + dir[1];
				dfs(image, r, c, newColor);
			}
		}
	}
}