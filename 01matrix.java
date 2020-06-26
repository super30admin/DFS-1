// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I took on sirs solution. I understood it well so no real problems. If given in 
// a real interview, I wonder if I could come up with a BFS solution quickly.


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // BFS
        
        if(matrix==null || matrix.length==0)
            return matrix;
        
        Queue<int[]> q=new LinkedList<>();
        // Find all 0's add it to queue
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {    
                    q.add(new int[] {i,j});
                }
                
                if(matrix[i][j]==1)
                    matrix[i][j]=-1;
            }
        }
        
        int dist=1;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                int[] curr=q.poll();
                
                for(int[] dir: dirs)
                {
                    int row=curr[0]+dir[0];
                    int column=curr[1]+dir[1];
                    
                    if(row>=0 && row<matrix.length && column<matrix[0].length && column>=0)
                    {
                        if(matrix[row][column]==-1)
                        {
                            q.add(new int[] {row,column});
                            matrix[row][column]=dist;   
                        }
                    }
                }
            }
            dist++;
        }
        
        return matrix;
    }
}