// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Mark the given index with the given color. if already marked,
 * then simply return. Once marked, then iterate in 4 directions to find
 * adjacent elements with the current color and call the same function on this
 * element and repeat this until we find no element with current color.
 *
 */
class Solution {
	int[] x4 = { 0, 1, 0, -1 };
	int[] y4 = { 1, 0, -1, 0 };

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		dfs(image, color, image[sr][sc], sr, sc);
		return image;
	}

	public void dfs(int[][] image, int color, int original, int sr, int sc) {
		if (image[sr][sc] == color)
			return;
		image[sr][sc] = color;
		for (int i = 0; i < 4; i++) {
			int x = sr + x4[i];
			int y = sc + y4[i];
			if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == original) {
				dfs(image, color, original, x, y);
			}
		}
	}
}