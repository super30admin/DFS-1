// Time Complexity :O(m*n) m-row length n-column length
// Space Complexity :O(m*n)  
// Did this code successfully run on Leetcode :yes
// Problems Faced: Idea of replacing all 1s initially as -1 to reach the 1s that wasn't surrounded by 0s. Everything else was easy to think
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
      if(matrix==null || matrix.length==0) return matrix;
      int m=matrix.length;
      int n=matrix[0].length;
      Queue<int[]> q=new LinkedList<>();
      for(int i=0;i<m;i++) //Time Complexity here: O(mn)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0) q.add(new int[]{i,j});
                else 
                    matrix[i][j] = -1;
            }
        }
        
        
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty())
        {
            int[] temp=q.poll();
            for(int[] dir:dirs)
            {
                int r=dir[0]+temp[0];
                int c=dir[1]+temp[1];
                
                if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] ==-1) 
                {
                matrix[r][c]=1+  matrix[temp[0]][temp[1]];
                q.add(new int[]{r,c});
                }                                                           
            }

            
        }

        return matrix;
    }
}