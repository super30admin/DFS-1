// Time complexity: O(MN) where M and N is the number of rows and columns
// Space complexity: O(MN) where M and N is the number of rows and columns


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int nr=matrix.length;
        if(nr==0)
            return matrix;
        int nc=matrix[0].length;
        int[][] dist=new int[nr][nc];
        for(int i=0;i<nr;i++)
            for(int j=0;j<nc;j++)
                dist[i][j]=Integer.MAX_VALUE -9000;
        for(int i=0;i<nr;i++)
        {
            for(int j=0;j<nc;j++)
            {
                if(matrix[i][j]==0)
                    dist[i][j]=0;
                else
                {
                    if(i>0)
                        dist[i][j]=Math.min(dist[i-1][j]+1,dist[i][j]);
                    if(j>0)
                        dist[i][j]=Math.min(dist[i][j-1]+1,dist[i][j]);                    
                }
            }
        }

        for(int i=nr-1;i>=0;i--)
        {
            for(int j=nc-1;j>=0;j--)
            {
                {
                    if(i<nr-1)
                        dist[i][j]=Math.min(dist[i+1][j]+1,dist[i][j]);
                    if(j<nc-1)
                        dist[i][j]=Math.min(dist[i][j+1]+1,dist[i][j]);                    
                }
            }
        }
        return dist;
    }
}
