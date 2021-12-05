// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
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
    
    public int[][] updateMatrix(int[][] mat) {
        
        int size;
        int distance = 0;
        
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                Pair newPair = q.poll();
                
                for (int[] dir : dirs) {
                    int row = newPair.getX() + dir[0];
                    int col = newPair.getY() + dir[1];
                    
                    if (row >= 0 && row < mat.length && col >= 0 && col < mat[0].length && mat[row][col] == -1) {
                        q.add(new Pair(row, col));
                        mat[row][col] = distance + 1;
                    }
                    
                }   
                
            }
            distance++;
        }
        return mat;
    }
}