//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.LinkedList;
import java.util.Queue;

// Use BFS approach to solve this problem as the time and space complexity will be O(m*n).
// This problem can also be solved with DFS but the time complexity, in worst case, will be O((m*n)^2) because
// all the matrix elements may be zeros. In this case we will be iterating all the matrix elements 
// except the current element for all the elements. Which takes O((m*n)^2) time.
// Space complexity in DFS approach is O(m*n) as the recusrive stack will be 
// having(in worst case) all the matrix elements at any time.

class Zero_One_Matrix_542 {
    public int[][] updateMatrix(int[][] matrix) {
        // Return the given matrix if it is empty
    	if(matrix == null || matrix.length == 0)
            return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        // Define Queue with type parameter as int[] to hold the row and column index of the matrix elements
        Queue<int[]> q = new LinkedList<>();
        // Iterate all the matrix elements
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
            	// if the element is zero, then push its row and column index into queue
                if(matrix[i][j] == 0)
                    q.add(new int[]{i,j});
                // else (the element is non zero, i.e, 1), then update it with -1
                else
                    matrix[i][j] = -1;
            }
        }
        
        int distance = 1;
        // Defeine the directions array (left, top, right, down).
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        while(!q.isEmpty())
        {
            int size = q.size();
            // Process all the Queue elements (size of Queue)
            for(int i = 0; i < size; i++)
            {
            	// Store the Queue element in temp array and delete from the Queue
                int[] temp = q.poll();
                // Iterate through the directions of the current Queue element
                for(int[] dir : dirs)
                {
                    int row = dir[0] + temp[0];
                    int col = dir[1] + temp[1];
                    // Check the boundary conditions and check whether the element is -1
                    if(row >= 0 && col >= 0 && row < m && col < n && matrix[row][col] == -1)
                    {
                    	// if the current element i.e, neighbor of the element we are processing in is -1 
                    	// then update it with the value of distance.
                        matrix[row][col] = distance;
                        q.add(new int[]{row, col}); // Add the current element's row and column indices to the Queue
                    }

                }
            }
            distance++; // Increment the distance at every iteration
            
        }
        return matrix; // Return the updated matrix
    }
}
