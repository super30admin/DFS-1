class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n= matrix[0].length;
        int[][] result = new int[m][n];
        for(int i =0; i<m;i++){
            for(int j = 0; j<n; j++){
                result[i][j] = dfs(matrix, result, i, j);
            }
        }
        return result;
    }
    private int dfs(int[][] matrix, int[][] result, int i, int j){
        int m = matrix.length;
        int n= matrix[0].length;
        //base case
        if(i < 0 || j< 0 || i > m-1 || j>n-1) return 9999;
        if(matrix[i][j] == 0) return 0;
        //top
        if(i > 0 && matrix[i-1][j] == 0) return 1;
        //left
        if(j > 0 && matrix[i][j-1] == 0) return 1;
        //right
        if(j < n-1 && matrix[i][j+1] == 0) return 1;
        //bottom
        if(i < m-1 && matrix[i+1][j] == 0) return 1;
        int left, right, top,bottom;
        left = top = 9999;
        if(i > 0  && result[i-1][j]!=0){
            top = result[i-1][j];
        }
        if(j > 0  && result[i][j-1]!=0){
            left = result[i][j-1];
        }
        bottom = dfs(matrix, result,i+1, j);
        right = dfs(matrix, result,i, j+1);
        
        return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1;
        
        
        
    }
}