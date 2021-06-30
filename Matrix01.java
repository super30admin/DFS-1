import java.util.*;

// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return matrix;
        }
        
        Queue<int[]> q = new java.util.LinkedList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i, j});
                }
                else{
                    matrix[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if(r >= 0 && c >= 0 && r < m && c < n && matrix[r][c] == -1){
                    q.add(new int[]{r, c});
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                }
            }
        }
        
        return matrix;
    }
}