// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I used DP to solve this problem. I first initialized a limit which is the maximum distance possible in the matrix. Then I iterated through the matrix from top-left to bottom-right, updating each cell with the minimum distance to a zero cell. After that, I iterated from bottom-right to top-left to ensure that all cells have the correct minimum distance.
// This ensures that each cell is updated with the minimum distance to a zero cell in both directions.

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int limit = mat.length + mat[0].length;
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                if(mat[i][j]==0) continue;
                int top = i>0?mat[i-1][j]:limit;
                int left = j>0?mat[i][j-1]:limit;
                mat[i][j] = Math.min(top,left)+1;
            }
        }
        for(int i = mat.length-1; i>=0; i--){
            for(int j = mat[0].length-1; j>=0; j--){
                if(mat[i][j]==0) continue;
                int bottom = i<mat.length-1?mat[i+1][j]:limit;
                int right = j<mat[0].length-1?mat[i][j+1]:limit;
                mat[i][j] = Math.min(mat[i][j],Math.min(bottom,right)+1);
            }
        }
        return mat;
    }
}