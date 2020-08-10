import java.util.LinkedList;
import java.util.Queue;

//Approach: BFS
//1. To calculate the nearest distance to Zero - I have used BFS to solve this, so here I have added the independent layer of zeroes to the queue and have changed all other 1s to be -1.
//2. Hence we will start processing the first level of zeroes added to queue and update the distance to all of its neighbors. Meanwhile adding them to queue as well.
//3. We will keep a dist variable to update the distance. When we have completed processing all the nodes, we might have updated their distance to the nearest zero.
//4. I have updated in the given matrix and returned it at the end.
class _01_Matrix {
    int level = 0;
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
           return matrix;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j] == 0)
                    q.add(new int[]{i,j});
                else
                    matrix[i][j] = -1;
            }
        }
        int dist = 1;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int[] curr = q.poll();
            
                for(int[] dir:directions)
                {
                    int r = curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    if(r >=0 && r <matrix.length && c >=0 && c < matrix[0].length && matrix[r][c] == -1)
                    {
                        matrix[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
            }
            }
            dist++;
        }
        return matrix;    
    }
}

//Time Complexity : O(m*n) 
//Space Complexity : O(m*n)  
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :