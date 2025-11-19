public class Solution {
        int[][] dirs;
        int rows;
        int columns;
        int[][] result;
    public int[][] UpdateMatrix(int[][] mat) {
        dirs = new int[][]{
        new int[]{-1,0},
        new int[]{0,-1},
        new int[]{1,0},
        new int[]{0,1}
    };
    rows = mat.Length;
    columns = mat[0].Length;
    result = new int[rows][];

    for (int i = 0; i < rows; i++)
    {
        result[i] = new int[columns];
    }
    for(int i=0;i<rows;i++)
    {
        for(int j=0;j<columns;j++)
        {
            if(mat[i][j]==1)
            {
                result[i][j] = dfs(mat,i,j);
            }
        }
    }
    return result;
        
    }
    int dfs(int[][] mat,int i, int j)
    {
        if(i>0 && mat[i-1][j]==0) return 1;
        if(i<(rows-1) && mat[i+1][j]==0) return 1;
        if(j>0 && mat[i][j-1]==0) return 1;
        if(j<(columns-1) && mat[i][j+1]==0) return 1;
        int top=9999,left=9999,bottom=9999,right=9999;
        if(i>0&&result[i-1][j]!=0)
        {
            top=result[i-1][j];
        }
        if(j>0&&result[i][j-1]!=0)
        {
            left=result[i][j-1];
        }
        if(j<(columns-1))
        {
            if(result[i][j+1]==0)
            {
                result[i][j+1]=dfs(mat,i,j+1);
            }
            right=result[i][j+1];
        }
        if(i<(rows-1))
        {
            if(result[i+1][j]==0)
            {
                result[i+1][j]=dfs(mat,i+1,j);
            }
            bottom=result[i+1][j];
        }
        return Math.Min(left,Math.Min(right,Math.Min(top,bottom))) +1;
    }
}