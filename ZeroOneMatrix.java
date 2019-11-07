// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Not passing all test cases

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = distanceToZero(matrix, i, j);
                }
            }
        }
        return matrix;
    }
    
    private int distanceToZero(int[][] matrix, int sr, int sc){
        if(matrix[sr][sc] == 0) return 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int minDistance = Integer.MAX_VALUE;
        for(int[] direction : directions){
            int row = sr + direction[0];
            int col = sc + direction[1];
            if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length) {
                // Find minimum distance to zero from each direction
                minDistance = Math.min(matrix[row][col], minDistance);
            }
        }
        
        return matrix[sr][sc] + minDistance;
    }
}
