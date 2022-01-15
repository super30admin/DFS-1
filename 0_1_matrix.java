// Time Complexity  : O(m *n)
// Space Complexity : O(m*n) : all nodes are 1 except 0 
class Solution {
      // row
    int m;
    int n;
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        
        if (mat ==  null || m == 0){
            return mat;
        }
        int[][] result =  new int[m][n];
        
        for (int i = 0; i < m ; i++){
            
            for ( int j = 0; j < n; j++){
                
                if (mat[i][j] != '0'){
                   result[i][j] = dfs(mat, result, i, j);
                }
            }
        }
        
        return result;
        
    }
    
    
    private int dfs(int[][] mat, int[][] result , int i, int j){
        
        // Do nothing for corner cases and if value is 0
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length){
            return 9999; //  any max value as we are searching for min value in each DFS
        } 
        
        if (mat[i][j] == 0){
            return 0;
        }
        
        // left element is 1
        if ( j > 0 && mat[i][j-1] == 0 ){
            return 1;
        }
        // right element is 1
        if ( j < n - 1 && mat[i][j+1] == 0 ){
            return 1;
        }
        // top element is 1
        if ( i > 0 && mat[i-1][j] == 0 ){
            return 1;
        }
        // bottom element is 1
        if ( i < m - 1 && mat[i+1][j] == 0 ){
            return 1;
        }
        
        int top = 9999,left=9999;
        
        if (i > 0 && result[i-1][j] != 0){
            
              top = result[i-1][j];
        }  

        if(j > 0 && result[i][j-1] != 0){
            left = result[i][j-1];
        }
        
        int bottom = dfs(mat, result, i+1, j);
        int right = dfs(mat, result, i, j+1);
               
        return Math.min(Math.min(top, bottom) , Math.min(left, right)) + 1;
    }
}