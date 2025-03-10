// Time Complexity : O(m*n) where m*n is the size of the matrix.
// Space Complexity : O(m*n)  size of queue.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.*;
class Solution {
    
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> que = new LinkedList<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j] == 0)
                    que.offer(new int[]{i, j});
                else
                    matrix[i][j] = -1;
            }
        }

        while(!que.isEmpty())
        {
            int size = que.size();
            for(int i=0; i<size; i++)
            {
                int[] node = que.poll();

                for(int k=0; k<dir.length; k++)
                {
                    int nrow = node[0] + dir[k][0];
                    int ncol = node[1] + dir[k][1];

                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && matrix[nrow][ncol] == -1)
                    {
                        matrix[nrow][ncol] = matrix[node[0]][node[1]] + 1;
                        que.offer(new int[]{nrow, ncol});
                    }  
                }
            }
        }
        
        return matrix;
    }
}