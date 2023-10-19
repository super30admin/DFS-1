//0-1 Matrix 
//TC(m*n)
//SC(m*n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat.length==0)
        {
            return null;
        }
        int m=mat.length;
        int n=mat[0].length;

        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    queue.add(new int[]{i,j}); //put all 0's in q
                }
                else
                {
                    mat[i][j]=-1; //to identify distance 1 and no 1
                }
            }
        }
        int dist=1;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                int[] curr=queue.poll();
                for(int[] dir:dirs)
                {
                    int nr=dir[0]+curr[0];
                    int nc=dir[1]+curr[1];
                    //bound chk
                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1)
                    {
                        queue.add(new int[]{nr,nc});//put inside queue
                        mat[nr][nc]=dist;
                    }
                }
            }
            dist++;
        }

      return mat;  
    }
}