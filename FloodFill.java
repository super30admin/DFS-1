import java.util.LinkedList;
import java.util.Queue;

/**
## Problem1: (https://leetcode.com/problems/flood-fill/)
 
Time Complexity :   O (m*n) 
Space Complexity :  O (m*n)
Did this code successfully run on Leetcode :    Yes (733. Flood Fill)
Any problem you faced while coding this :       No
 */

// Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
// Output: [[2,2,2],[2,2,0],[2,0,1]]

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // base case
        if(image == null || image[sr][sc] == newColor)
            return image;
        
        int m = image.length;
        int n = image[0].length;
        
        // dirs array to nevigate to 4 directions
        int[][] dirs = new int[][]{{0,1}, {-1, 0}, {0, -1}, {1, 0}};
        
        // save the original color for later use
        int color = image[sr][sc];
        
        Queue<int[]> q = new LinkedList<>();

        // add the 1st color co-ordinates in queue to start nevigation
        q.add(new int[]{sr,sc});
        
        // update the color of start co-ordinates with newColor
        image[sr][sc] = newColor;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int dir[]: dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                
                // boundry check
                if(nr>=0 && nc>= 0 && nr<m && nc<n && image[nr][nc] == color){
                    q.add(new int[]{nr,nc});
                    image[nr][nc] = newColor;
                }
            }
        }
        return image;
    }
}