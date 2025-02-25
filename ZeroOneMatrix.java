class ZeroOneMatrix {
    int[][] dp;
    int m;
    int n;
    public int[][] updateMatrix(int[][] mat) {
        
        m=mat.length;
        n= mat[0].length;
        this.dp = new int[m][n];
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                if(mat[i][j]==1)
                {
                    dp[i][j] =dfs(mat,i,j);
                }
               
            }
        }
        return dp;
        
    }

    private int dfs(int[][] mat,int i, int j)
    {
        
        //logic
        if(j<n-1 && mat[i][j+1]==0)
        return 1;
        if(j>0 && mat[i][j-1]==0)
        return 1;
        if(i>0 && mat[i-1][j]==0)
        return 1;
        if(i<m-1 && mat[i+1][j]==0)
        return 1;
        


        int top = 99999;
        if(i>0 && dp[i-1][j]!=0)
        {
            top=dp[i-1][j];
        }
        
        int left =  99999;
        if(j>0 && dp[i][j-1]!=0)
        {
            left=dp[i][j-1];
        }
        int bottom = 99999;
        if(i<m-1)
        {
            if(dp[i+1][j]==0)
            {
                dp[i+1][j] =dfs(mat,i+1,j);
            }
            bottom =  dp[i+1][j];
        }
         int right= 99999;
        if(j<n-1)
        {
            if(dp[i][j+1]==0)
            {
                dp[i][j+1] =dfs(mat,i,j+1);
            }
             right =  dp[i][j+1];
        }
       
        return Math.min(right, Math.min(top,Math.min(bottom,left)))+1;
        
    }

}

//tc: O(m*n)
//sc: O(m*n)