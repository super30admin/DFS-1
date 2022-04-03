// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

import java.util.*;

class Solution {
    
    private int[][] directions = {
        {0,  1},
        {1,  0},
        {-1, 0},
        {0, -1}
    };
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
                
                else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int distance = 1;
        
        while (!q.isEmpty()) {
            
            Queue<int[]> next = new LinkedList<>();
            
            while (!q.isEmpty()) {
                int[] xy = q.remove();
                
                for (int[] dir : directions) {
                    
                    int newX = xy[0] + dir[0];
                    int newY = xy[1] + dir[1];
                    
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        
                        if (mat[newX][newY] == -1) {
                            
                            //maintain distance, visited status
                            mat[newX][newY] = distance;
                            
                            next.add(new int[] {newX, newY});
                        }
                    }
                }
            }
            
            distance++;
            q = next;
        }
        
        return mat;
    }
}