import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


/*
 * Approach 1 - BFS
 * Add the element to the queue, remove the element from the queue
 * and iterate over all four directions. before adding element to the queue, change the color to new color.
 * 
 */
public class FloodFill {
    int oldColor;
    int dirs[][];
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image[sr][sc] == color)
        {
            return image;
        }
        
        int m = image.length;
        int n = image[0].length;
        
         dirs = new int [][] {{1,0},{0,1},{-1,0},{0,-1}};
         oldColor = image[sr][sc];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;
        
        while(!q.isEmpty())
        {
            int r = q.poll();
            int c = q.poll();
            
            for(int dir[]: dirs)
            {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(nr < m && nc < n && nr >= 0 && nc >= 0 && image[nr][nc] == oldColor)
                {
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}

/*
 * Approach 2 - DFS
 * We use a recursive stack here instead of a queue. 
 */
class Solution {
    int dirs[][];
    int oldCol;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image == null || image[sr][sc] == color)
            return image;
        
        dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int m = image.length;
        int n = image[0].length;
        oldCol = image[sr][sc];
        dfs(image,sr,sc,color,m,n);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color,int m,int n){
        //base
        if( sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != oldCol)
            return;
        //logic
        image[sr][sc] = color;
        for(int[] dir:dirs)
        {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            
            dfs(image,nr,nc,color,m,n);
        }
    }
}