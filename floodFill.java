// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : None.


// Your code here along with comments explaining your approach
class Solution {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		 if(image == null || image[sr][sc] == color) return image;

		 int m = image.length;
		 int n = image[0].length;
		 
		 int[][] dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
		 
		 int targetColor = image[sr][sc];
		 
		 // BFS
		 image[sr][sc] = color;
		 Queue<int[]> q = new LinkedList<>();
		 
		 q.add(new int[]{sr, sc});
		 while(!q.isEmpty()) {
			  int[] curr = q.poll();
			  for(int dir[] : dirs) {
					int nr = curr[0] + dir[0];
					int nc = curr[1] + dir[1];
					
					if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc] == targetColor) {
						 q.add(new int[]{nr, nc});
						 image[nr][nc] = color;
					}
			  }
		 }
		 // dfs(image, sr, sc, color, m, n, dirs, targetColor);
		 return image;
	}
	
	// DFS approach
	private void dfs(int[][] image, int sr, int sc, int newColor, int m, int n, int[][] dirs, int color) {
		 //base
		 if(sr<0 || sc<0 || sr == m || sc == n || image[sr][sc] != color) return;
		 
		 //logic
		 image[sr][sc] = newColor;
		 for(int[] dir : dirs) {
			  int nr = dir[0] + sr;
			  int nc = dir[1] + sc;
			  
			  dfs(image, nr,nc,newColor,m,n,dirs, color);
		 }
	}
}