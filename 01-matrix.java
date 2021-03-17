// Time Complexity :
O(M*N) where M and N are no of rows and columns
// Space Complexity :
O(M*N) recursive stack in DFS
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
  //Define directions array
  int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    
    public int[][] updateMatrix(int[][] matrix) {
       
        if(matrix == null || matrix.length == 0){
            return matrix;
        }
        
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    helper(matrix, i, j, 0);
                }
            }
        }
        
        //we will return the result
        return matrix;
    }
    
    //Since it's changing the input itself itself, it's void
    private void helper(int[][] matrix, int i, int j, int distance){
       
        matrix[i][j] = distance;
        for (int[] direction : directions) {
            int row = direction[0] + i;
            int col = direction[1] + j;
            if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= distance + 1){
                continue;
            }
            helper(matrix, row, col, distance + 1);
        }
    }
}