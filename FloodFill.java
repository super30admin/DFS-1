// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        int[][] dirs = {
            {-1, 0}, 
            {0, 1}, 
            {0, -1},
            {1, 0}, 
        };
        
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        queue.add(new Pair(sr, sc));
        image[sr][sc] = newColor;
        while(!queue.isEmpty()) {
            
            Pair<Integer, Integer> cell = queue.poll();
            
            int row = cell.getKey();
            int col = cell.getValue();
            
            for(int[] dir: dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && image[newRow][newCol] == color) {
                    image[newRow][newCol] = newColor;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
        return image;
    }
}
