class Solution {
    //tc = o(m*n)2
    //sc =o(m*n)
    int[][] dirs;
    int m;
    int n;
    public int[][] updateMatrix(int[][] mat) {
         dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        if(mat == null || mat.length == 0) return mat;
        m = mat.length;
        n = mat[0].length;        
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 1)
                    mat[i][j] =-1;
            }
        }
        
        for(int i = 0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 0)
                {
                   dfs(mat,i,j,0);
                }
               
            }
        }
        return mat;  
        

    }
    private void dfs(int[][]mat,int i,int j,int dist)
    {
        //basecase
        if(i<0||j<0|| i==m||j==n) return;
        if(mat[i][j] < dist &&mat[i][j] != -1) return;
        
        
        int curr = mat[i][j];
        mat[i][j] = dist;
        //logic
        for(int[] dir : dirs)
        {
            int nr = i+dir[0];
            int nc = j+dir[1];
            dfs(mat,nr,nc,dist+1);
        }
      
    }
}