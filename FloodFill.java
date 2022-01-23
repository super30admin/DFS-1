package dfs1;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	
	//DFS
	//Time Complexity : O(m*n), where m are the rows and n are the columns of the matrix
	//Space Complexity : O(m*n), for internal stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor)
            return image;
        
        int origColor = image[sr][sc];
        dfs(image, sr, sc, newColor, origColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int origColor) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != origColor)
            return;
        
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, newColor, origColor);
        dfs(image, sr, sc + 1, newColor, origColor);
        dfs(image, sr - 1, sc, newColor, origColor);
        dfs(image, sr, sc - 1, newColor, origColor);
    }
    
    //BFS
  	//Time Complexity : O(m*n), where m are the rows and n are the columns of the matrix
  	//Space Complexity : O(m*n), for queue
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor)
            return image;
        
        int originalColor = image[sr][sc];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr, sc});
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        image[sr][sc] = newColor;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                
                if(row >= 0 && col >= 0 && row < image.length && col < image[0].length && image[row][col] == originalColor) {
                    q.offer(new int[] {row, col});
                    image[row][col] = newColor;
                }
            }
        }
        
        return image;
    }
}
