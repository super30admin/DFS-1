// Time Complexity : O(m*n)
// Space Complexity : O(min(m,n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }
    
    private static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int currColor = image[sr][sc];
        
        if (currColor == newColor) {
            return image;
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(sr, sc));
        
        while (!q.isEmpty()) {
            Pair newPair = q.poll();
            
            image[newPair.getX()][newPair.getY()] = newColor;
            
            for (int[] dir : dirs) {
                int row = newPair.getX() + dir[0];
                int col = newPair.getY() + dir[1];
                
                if (row >= 0 && row < image.length && col >= 0 && col < image[0].length) {
                    if (image[row][col] == currColor) {
                        
                        q.add(new Pair(row, col));
                    }
                }
            }
            
        }
        return image;
    }
}