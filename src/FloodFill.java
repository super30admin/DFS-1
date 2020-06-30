// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * 
 * https://leetcode.com/problems/flood-fill/
 *
 */
public class FloodFill {

	//bfs solution
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		if(image == null || image.length == 0) return image;

		Queue<int[]> q = new LinkedList<>();

		if(image[sr][sc] == newColor) return image;

		int startColor = image[sr][sc];
		int m = image.length, n = image[0].length;

		q.add(new int[]{sr, sc});

		int[][] dirs = {{-1,0}, {1,0}, {0,-1},{0,1}};

		while(!q.isEmpty()) {
			int[] loc = q.poll();

			image[loc[0]][loc[1]] = newColor;

			for(int[] dir: dirs) {
				int row = loc[0] + dir[0];
				int col = loc[1] + dir[1];

				if(row >=0 && row < m && col >=0 && col < n && image[row][col] == startColor) {
					q.add(new int[]{row,col});
				}
			}
		}

		return image;

	}

	//DFS solution
	public int[][] floodFillDfs(int[][] image, int sr, int sc, int newColor) {
		if(image == null || image.length == 0) return image;
		if(image[sr][sc] == newColor) return image; 

		int startColor = image[sr][sc];

		dfs(image, sr, sc, newColor, startColor);

		return image;
	}

	private void dfs(int[][] image, int sr, int sc, int newColor, int startColor){
		//base
		if(!(sr >=0 && sr < image.length && sc >=0 && sc < image[0].length && image[sr][sc] == startColor)){
			return;
		}

		//logic
		image[sr][sc] = newColor;

		for(int[] dir: dirs){
			int row = sr + dir[0];
			int col = sc + dir[1];

			dfs(image, row, col, newColor, startColor);

		}
	}
}
