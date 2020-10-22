// Time Complexity : O(r * c) - As we traverse through the whole matrix with r rows and c columns
// Space Complexity : O(r * c) - As we use a additional 2D data structure and store values in it using DP
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return matrix;
        int[][] res = new int[matrix.length][matrix[0].length];
        for(int i = 0;i < res.length;i++){
            for(int j = 0;j < res[0].length;j++){
                res[i][j] = Integer.MAX_VALUE - 100000;
            }
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    res[i][j] = 0;
                }
                else{
                    if(i > 0){
                        res[i][j] = Math.min(res[i][j],res[i - 1][j] + 1);
                    }
                     if(j > 0){
                        res[i][j] = Math.min(res[i][j],res[i][j - 1] + 1);
                    }
                }
            }
        }
        for(int i = matrix.length - 1;i >=0;i--){
            for(int j = matrix[0].length - 1;j >= 0;j--){
                
                    if(i < matrix.length - 1){
                        res[i][j] = Math.min(res[i][j],res[i + 1][j] + 1);
                    }
                     if(j < matrix[0].length - 1){
                        res[i][j] = Math.min(res[i][j],res[i][j + 1] + 1);
                    }  
            }
        }
        return res;
    }
}
// Your code here along with comments explaining your approach