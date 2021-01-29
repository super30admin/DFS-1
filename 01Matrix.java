// Time Complexity : O(n*m) n - rows  m - columns
// Space Complexity : O(n+m)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : Yes 


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
       
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Integer> q = new LinkedList<>(); 
       for(int i=0;i<m;i++)
       {
           for(int j=0;j<n;j++)
           {
               if(matrix[i][j]==0)
               {
                q.add(i);
                q.add(j);  
                
               }else{
                   matrix[i][j]=-1;
               }
           }
       }    
      
      int count = 0;  
      int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
      while(!q.isEmpty())
      {
          int r = q.poll();
          int c = q.poll();
          count = matrix[r][c]+1;
          for(int [] dir: dirs)
          {   
              int row = r + dir[0];
              int col = c + dir[1];
              if(row>=0 && row<m && col>=0 && col<n && matrix[row][col]==-1)
              {
                  matrix[row][col] = count;
                  q.add(row);
                  q.add(col);
              }
          }
          
      }
        
        
        
        return matrix;
    }
}