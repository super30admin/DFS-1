
// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will conside all the 0s in the matrix as level 1 and all its neighboring 1s as level 2 and so on. 
//We will add all the 0s in the queue and all the 1s in the matrix as -1, so that we should be able to distinguish between the 1s present in the matrix with the mutated ones. We will start the distance with 1 so that the first -1 ,
// that we will get in the matrix should be updated with 1. We will move through all the four directions and find the neighboring -1s and keep updating their distances.

class Solution {
    public int[][] updateMatrix(int[][] matrix) 
    {
        int m=matrix.length; //rows
        int n=matrix[0].length; //cols
        int [][] dirs=new int[][] {{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0) //Level 1
                {
                    q.add(new int [] {i,j});
                }
                else
                {
                    matrix[i][j]=-1;
                }
            }
        }

       int dist=1;

       while(!q.isEmpty())
       {
           int size=q.size();
           for(int i=0;i<size;i++)
           {
               int [] curr=q.poll();

               for(int[]dir: dirs)
               {
                   int nr=curr[0]+dir[0];
                   int nc=curr[1]+dir[1];

                   if(nr>=0 && nc>=0 && nr<m && nc<n && matrix[nr][nc]==-1)
                   {
                       matrix[nr][nc]=dist;
                       q.add(new int [] {nr,nc});
                   }
               }
           }
           dist++;
       }

    return matrix;

        
    }
}
