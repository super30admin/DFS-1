// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        
        if(mat == null || mat.length == 0) return mat;
        
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] dirs = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                
                if(mat[i][j] == 0) {
                    queue.add(new Pair(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> cell = queue.poll();
            
            int row = cell.getKey();
            int col = cell.getValue();
            
            for(int[] dir: dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && mat[newRow][newCol] == -1) {
                    mat[newRow][newCol] = mat[row][col] + 1;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
        
        return mat;
    }
}
