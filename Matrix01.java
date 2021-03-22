// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Here we are using a bfs approach. We intiailly make all the 1's in the matrix as -1. we start by adding all the 0's to the queue and that is the first level of bfs for us.
//We take variable dist as 1. When performing bfs on the second level , me make the -1's as 1s and increment the distance when the first level is done processing.
//On the next level again we have all -1s , here we now make all elements equal to distance as 2. We keep on doing this for all elements and hence the resultant matrix contains 
//the distance of it from the first level , which has all 0s.

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
      if(matrix==null || matrix.length==0)
      {
        return matrix;
      }
      
      Queue<int[]> queue = new LinkedList<>();
      
      int m = matrix.length;
      int n = matrix[0].length;
      
      int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
      
      for(int i=0;i<m;i++)
      {
        for(int j=0;j<n;j++)
        {
          if(matrix[i][j]==0)
          {
            queue.add(new int[]{i,j});
          }
          else
          {
            matrix[i][j]=-1;
          }
        }
      }
      int dist = 1;
      
      while(!queue.isEmpty())
      {
        int size = queue.size();
        for(int i=0;i<size;i++)
        {
          int[] current = queue.poll();
          
          for(int dir[]:dirs)
          {
            int r = dir[0]+current[0];
            int c = dir[1]+current[1];
            
            if(r>=0 && c>=0 && r<m && c<n && matrix[r][c]==-1)
            {
              queue.add(new int[]{r,c});
              matrix[r][c]=dist;
            }
          }
        }
        dist++;
      }
        return matrix;
    }
}