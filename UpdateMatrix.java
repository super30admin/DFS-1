// Time Complexity: O(mn)..It is linear with respect to input
// Space Complexity: O(mn).. Since we are using q and if all the nodes are zero then we will put all mn nodes into the queue. Hence Space Complexity is O(mn)
//LeetCode: 542. 01 Matrix - Medium
// Using BFS but in a slightly different way.
class Solution {
    int[][] dirs;
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m=mat.length;
        int n=mat[0].length;
       
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
      //  boolean[][] visited=new boolean[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new int[]{i,j});
                    //visited[i]=true;
                }
                else
                {
                    mat[i][j]=-1;
                }
            }
        }
        int len=0, level=0;
        int[] curr;
        int r,c;
       while(!q.isEmpty())
       {
           len=q.size();
           level++;
           for(int i=0;i< len;i++)
           {
               curr=q.poll();
               
               for(int[] dir: dirs)
               {
                   r=curr[0]+dir[0];
                   c=curr[1]+dir[1];
                    
                   if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1 )
                   {
                       
                           mat[r][c]=level;
                          q.add(new int[]{r,c});                                       
                     
                      
                   }
               }
           }
           
       }
        
        return mat;
    }
}