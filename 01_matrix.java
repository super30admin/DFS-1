//TC: O(m*n)
//SC: O(m*n)
class Solution {
    int[][] dirs;
    public int[][] updateMatrix(int[][] mat) {
        this.dirs=new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        int m=mat.length;
        int n=mat[0].length; 
   Queue<int []> q=new LinkedList<>();
   int distance=1;
      for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
           if(mat[i][j]==0)
           {
               q.add(new int[] {i,j});
           }
           else
           {
               mat[i][j]=-1;
           }
        }
    }
while(!q.isEmpty())
{
    int size=q.size();
    for(int i=0;i<size;i++)
    {
    int[] temp=q.poll();
    for(int dir[]:dirs)
    {
        int nr=dir[0]+temp[0];
        int nc=dir[1]+temp[1];
        if(nr>=0&&nc>=0&&nr<m&&nc<n&&mat[nr][nc]==-1)
        {
            mat[nr][nc]=distance;
            q.add(new int [] {nr,nc});
        }
    }
    }
    distance++;
}
return mat;
    }
}