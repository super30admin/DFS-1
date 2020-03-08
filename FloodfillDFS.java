
// Time Complexity :O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FloodfillDFS {

	int[][] dirs;
	int color;

	private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		if (image == null || image.length == 0 || image[sr][sc] == newColor) {
			return image;
		}

		dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		color = image[sr][sc];
		dfs(image, sr, sc, newColor);

		return image;

	}

	private void dfs(int[][] image, int r, int c, int newColor) {

		if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != color)
			return;
		
		
			image[r][c] = newColor;

		for (int[] dir : dirs) {
			int i = dir[0] + r;
			int j = dir[1] + c;
			
			dfs(image,i, j, newColor);
		}

	}

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		FloodfillDFS f = new FloodfillDFS();
		f.floodFill(image, 1, 1, 2);
	}

}
