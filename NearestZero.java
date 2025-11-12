
//Time Complexity:O(m*n)
//Space Complexity:O(m*n)
//First, we set all 1s to a large value and leave 0s as they are.
//Then we traverse the matrix from top-left to bottom-right, updating distances based on top and left neighbors.
//Finally, we traverse back bottom-right to top-left, updating using bottom and right neighbors.
public class NearestZero {
        public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j] = 100000;
            }
        }


        //First pass traverses from top-left to bottom pass

       for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 0)
                {
                    dp[i][j] = 0;
                }
                else
                {
                    if(i>0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                    if(j>0) dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
                }
            }
        }


        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                    if(i+1<m) dp[i][j] = Math.min(dp[i][j], dp[i+1][j]+1);
                    if(j+1<n) dp[i][j] = Math.min(dp[i][j], dp[i][j+1]+1);
            }
        }

        return dp;
    }
}
