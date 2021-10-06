// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, a bit understanding in levels


// Your code here along with comments explaining your approach
/*Approach:
1) in this, we need to mutate the same matrix and the mutated values provide the min time taken to reach the other 0, like starting from 0 how much distance we took to reach the next 0.
2) Thus to do this, we peform a BFS and we store all positions of 0 in a queue and rest 1's are mutated as -1
3) we do it as we are mutating the same matrix and if suppose we change the distance to 1 and we might encounter similar value as 1 again which we might have traversed already.
thus we replace all 1's with -1
4) Level yes or No
    -> we need level as it would give us the nearest distance from one zero to another.
    -> thus levels are essential and this can be achieved by starting the level at 1. we start at 1, coz that value would be used to mutate anpther value and it would be part of answer.
5) if we find a -1 value, we put the x and y co=ordinates in queue, indicating we have to mutate them as they are not being traversed.

*/




class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        if(mat==null || mat.length==0)
        {
            return mat;
        }
        
        int m=mat.length;
        int n = mat[0].length;
        
        Queue<Integer> rowQueue = new LinkedList();
        Queue<Integer> colQueue = new LinkedList();
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                if(mat[i][j]==0) // need to begin the BFS
                {
                    rowQueue.add(i);
                    colQueue.add(j);
                }
                else
                {
                    mat[i][j]=-1; // make all 1's to -1
                }
            }
        }
        
        // we maintain a level value coz we can have to return distance of nearest 0 from each cell, thus we can have the level thus we can limit the queue size to that particular level
        
     int level=1;
     int[][] dirs = new int[][]{{0,-1},{0,1},{1,0},{-1,0}}; 
        while(!rowQueue.isEmpty())
        {
            int size = rowQueue.size();
            for(int i=0;i<size;i++)
            {
                int xVal = rowQueue.poll();
                int yVal = colQueue.poll();
                
                for(int dir[] : dirs)
                {
                    int newX= xVal+dir[0];
                    int newY = yVal + dir[1];
                    
                    if(newX>=0 && newX<m && newY>=0 && newY<n && mat[newX][newY]==-1)
                    {
                        rowQueue.add(newX);
                        colQueue.add(newY);
                        mat[newX][newY] = level;
                    }
                }
                
            }
            level++;
            
        }
        
        return mat;
    }
}