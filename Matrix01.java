// Time Complexity :O(N x  M) + O(N x M) 
            //since we are looking through the matrix
            //And worst case BFS will go through the entire matrix again.
// Space Complexity : O(N x M) as we might have the entire matrix in the queue we are using.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : it was difficult to come up with the intuition of 
        // changing all the ones to Int.MAX_VALUE.

import java.util.*;

public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        
        Queue<int[]> bfsQue = new LinkedList<>();
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    //add to queue
                    bfsQue.add(new int[]{i, j});
                } else if(matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        while(!bfsQue.isEmpty()) {
            int[] temp = bfsQue.poll();
            
            for(int[] dirs: directions) {
                int r = temp[0] + dirs[0];
                int c = temp[1] + dirs[1];
                
                if(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length
                    && matrix[r][c] != 0) {
                    if(matrix[temp[0]][temp[1]] + 1 < matrix[r][c]) {
                        bfsQue.add(new int[]{r,c});
                        matrix[r][c] = matrix[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }
        
        return matrix;
    }
}
