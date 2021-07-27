// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.*;


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        
        Queue<int[]> q = new LinkedList<>();
        
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        q.add(new int[]{sr, sc});
        
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        int m = image.length, n = image[0].length;
        
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            
            for(int[] dir: dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == color){
                    image[r][c] = newColor;
                    q.add(new int[]{r, c});
                }
            }
            
        }
        
        return image;
    }
}