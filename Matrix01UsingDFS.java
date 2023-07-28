package DFS;
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
public class Matrix01UsingDFS {

    int m; int n;
    public int[][] updateMatrix(int[][] mat) {

        m = mat.length;
        n = mat[0].length;
        int[][] result = new int[m][n];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j]==1)
                {
                    mat[i][j] = -1;
                }
            }
        }
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j]==-1)
                {
                    result[i][j] = dfs(mat,result,i,j);
                }
            }
        }

        return result;

    }

    public int dfs(int[][] mat, int[][] result, int i, int j)
    {
        if(mat[i][j] == 0) return 0;
        if(i+1<m && mat[i+1][j] == 0) return 1;
        if(i>0 && mat[i-1][j] == 0) return 1;
        if(j+1<n && mat[i][j+1] == 0) return 1;
        if(j>0 && mat[i][j-1] == 0) return 1;
        int top = 9999;
        int left = 9999;
        int bottom = 9999;
        int right = 9999;

        if(i>0 && result[i-1][j]!=0)
        {
            top = result[i-1][j];
        }
        if(j>0 && result[i][j-1]!=0)
        {
            left = result[i][j-1];
        }
        if(i+1<m)
        {
            if(result[i+1][j] == 0)
            {
                result[i+1][j] = dfs(mat,result,i+1,j);
            }
            bottom = result[i+1][j];

        }
        if(j+1<n)
        {
            if(result[i][j+1] == 0)
            {
                result[i][j+1] = dfs(mat,result,i,j+1);
            }
            right = result[i][j+1];
        }

        return Math.min(top,Math.min(left,Math.min(bottom,right)))+1;
    }
}
