
/*

Time Complexity - O(r . c)
Space Complexity - O(1)
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rowSize = mat.length;
        if (rowSize == 0) 
            return mat;
        
        int colSize = mat[0].length;
        final int INF = rowSize + colSize;
        int[][] dp = new int[rowSize][colSize];
         
        for(int i = 0; i < rowSize; i++)
            for(int j = 0; j < colSize; j++) {
                int top = INF, left = INF;
                if(mat[i][j] == 0)
                    continue;
                else {
                    if(i > 0)
                        top = dp[i-1][j] + 1;
                    if(j > 0)
                        left = dp[i][j-1] + 1;
                    dp[i][j] = Math.min(top,left);
                }
            }
        for(int i = rowSize - 1; i >= 0; i--)
            for(int j = colSize - 1; j >= 0; j--) {
                int right = INF, bottom = INF;
                if(mat[i][j] == 0)
                    continue;
                else {
                    if(i < rowSize - 1)
                         right = dp[i+1][j] + 1;
                    if(j < colSize - 1)
                         bottom = dp[i][j+1] + 1;
                    dp[i][j] = Math.min(dp[i][j], Math.min(right, bottom));
                }
            }
        return dp;
    }
}
