// DFS + DP
// so we ignore the left and the top side. The reason is that we will get stuck on infinite loop the second we take left and top side.
// Time complexity = O(m*n)
// Space complexity = O(m*n)
class Solution {
    int[][] dp;
    int m;
    int n;
    int[][] dirs;
    public int[][] updateMatrix(int[][] mat) {
        if(mat== null ||  mat.length==0) return mat;
        this.m = mat.length;
        this.n = mat[0].length;
        dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i=0;i< m ;i++) {
            for(int j=0;j< n ;j++) {
                if(mat[i][j]==1) {
                    mat[i][j] = -1;
                }
            }
        }
        this.dp = new int[m][n];
        for(int i=0;i< m ;i++) {
            for(int j=0;j< n ;j++) {
                if(mat[i][j]==-1) {
                    dp[i][j] = dfs(mat, i, j);
                }
            }
        }
        return dp;
    }
    
    private int  dfs(int[][] mat, int i, int j) {
        // base case
        // the neighbors are 0.
        if(i< m-1 && mat[i+1][j] == 0 ) return 1;
        if(i>0 && mat[i-1][j]==0) return 1;
        if(j<n-1 && mat[i][j+1]==0) return 1;
        if(j>0 && mat[i][j-1]==0) return 1;
        
        // logic
        int top = 99999;
        int bottom = 99999;
        int left = 99999;
        int right = 99999;
        
        // ignore the top and left
        // top
        if(i>0 &&  dp[i-1][j] !=0) {
            top = dp[i-1][j];
        }
        // left
        if(j>0 && dp[i][j-1]!=0) {
            left = dp[i][j-1];
        }
        
        // do dfs on bottom and the right
        // bottom 
        if(i< m-1) {
            if(dp[i+1][j] ==0 ) {
                dp[i+1][j] = dfs(mat, i+1,j);
            }
            bottom = dp[i+1][j];
        }
        
        // right
        if(j< n-1) {
            if(dp[i][j+1]==0) {
                dp[i][j+1] = dfs(mat, i, j+1);
            }
            right = dp[i][j+1];
        }
        // take the miniumum distance of the neighbors.
        return Math.min(right, Math.min(left, Math.min(bottom, top)))+1;
    }
    
}