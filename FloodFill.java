import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	// Time Complexity : O(mn)
	// Space Complexity : O(mn)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : No
	// Your code here along with comments explaining your approach
	/*
	 * This approach is by using BFS method.
	 * Here, when traversing the matrix, we will start image[sr][sc] position and add it inside the queue.
	 * and initialize the image[sr][sc] to the newColor
	 * When the traversal comes across its neighboring level with the original color then change their values to newColor.
	 */
	//BFS
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        Queue<Integer> q = new LinkedList<>();
        int [][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        int originalColor = image[sr][sc];
        q.add(sr);
        q.add(sc);
        image[sr][sc] = newColor;
        while(!q.isEmpty()){
            int currRow = q.poll();
            int currCol = q.poll();
            for(int [] dir : dirs){
                int r = dir[0] + currRow;
                int c = dir[1] + currCol;
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == originalColor){
                    image[r][c] = newColor;
                    q.add(r);
                    q.add(c);
                }
            }
        }
        return image;
    }
    
    // Time Complexity : O(mn)
 	// Space Complexity : O(mn)
 	// Did this code successfully run on Leetcode : yes
 	// Any problem you faced while coding this : No
 	// Your code here along with comments explaining your approach
 	/*
 	 * This approach is by using DFS method.
 	 * Here, when traversing the matrix, we will start image[sr][sc] position and pushed inside the recursive stack under the hood.
 	 * and image[sr][sc] is changed to the newColor.
 	 * When the traversal comes across its neighboring level with not the original color then the call will be returned.
 	 */
    
    //DFS
    int m;
    int n;
    int originalColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        originalColor = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base
        if(sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] != originalColor) return;
        //logic
        image[sr][sc] = newColor;
        int [][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int [] dir : dirs){
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(image, r, c, newColor);
        }
    }
    
}
