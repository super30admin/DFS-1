//Time complexity: O(V+E) => O(N)
//Space Complexity: O(V+E) => O(N)
//Tried on leetcode and accepted attempts: 5
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length ;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = dfs(matrix, res, i, j);
            }
        }
       return res;     
    }
    public static int dfs(int[][] matrix,int[][] res, int i, int j){
        int m = matrix.length ;
        int n = matrix[0].length;
        // Base Case 
        //If it exceeds 10000
         if(i<0 || i>=m || j < 0 || j >= n) return 9999;
         if(matrix[i][j] == 0) return 0;
         // Case 1 find 0 on 4 adjacent cells top,right,down, left
         if((i > 0 && matrix[i-1][j] == 0)||(j < n-1 && matrix[i][j+1] == 0)||(i < m-1 && matrix[i+1][j] == 0)||(j>0 && matrix[i][j-1] == 0)) return 1;
        // Case when no zero around perform DFS
        int left,bottom,right,top;
        left=top=9999;
        // if recursive call
        if(i > 0 && res[i-1][j] != 0){
            top = res[i-1][j];
        }
        if(j> 0 && res[i][j-1] != 0){
            left = res[i][j-1];
        }
        
        bottom = dfs(matrix, res,i+1, j);
        right = dfs(matrix, res,i,j+1);
        return Math.min(Math.min(left, right), Math.min(top,bottom))+1; 
    }
}