import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//733. Flood Fill (Easy) - https://leetcode.com/problems/flood-fill/
class Solution {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		// Time Complexity : O(m*n), Space Complexity : O(m*n)
//        if (image == null || image.length == 0) return image;
//        
//        int m = image.length, n = image[0].length, actualColor = image[sr][sc];
//        
//        if (actualColor == color) return image;
//        
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[] {sr, sc});
//        image[sr][sc] = color;
//        
//        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        
//        while (!queue.isEmpty()) {
//            int[] curr = queue.poll();
//            
//            for (int[] dir : dirs) {
//                int row = curr[0] + dir[0];
//                int col = curr[1] + dir[1];
//                
//                if (row >= 0 && row < m && col >= 0 && col < n && image[row][col] == actualColor) {
//                    queue.add(new int[] {row, col});
//                    image[row][col] = color;
//                }
//            }
//        }
//        
//        return image;

		if (image == null || image.length == 0)
			return image;

		int oldColor = image[sr][sc];

		if (oldColor == color)
			return image;

		int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		dfs(image, sr, sc, oldColor, color, dirs);

		return image;
	}

	private void dfs(int[][] image, int row, int column, int oldColor, int newColor, int[][] dirs) {
		// base
		if (row < 0 || row >= image.length || column < 0 || column >= image[0].length || image[row][column] != oldColor)
			return;

		// logic
		image[row][column] = newColor;

		for (int[] dir : dirs) {
			int nr = row + dir[0];
			int nc = column + dir[1];
			dfs(image, nr, nc, oldColor, newColor, dirs);
		}
	}
}