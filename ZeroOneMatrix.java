package Nov12;

import java.util.LinkedList;
import java.util.Queue;

class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        
/*
  Time Complexity: O(m*n) where m is number of rows and n is number of columns in image grid.
  Because we will iterate through all the nodes of the given matrix.
  
  Space Complexity: O(m*n)
  Because from 1 new colored node, 4 neighbor nodes can get affected. Each of those 4 nodes can further affect 4*4 neighbor nodes. This can very soon cover the entire grid of m*n.  
 
  Did this code successfully run on Leetcode : Yes
 
  Any problem you faced while coding this : No
     
  Approach: 
  BFS approach taken.
                        
*/ 
  
      // edge condition
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        
        Queue<int[]> queue = new LinkedList<>();
    
        int m = matrix.length;
        int n = matrix[0].length;
        
        // adding coordinates of all nodes with value 0 to queue 
        // altering all 1s in the given matrix to -1 to differentiate between distance value =1 which will be replaced as the nodes value in the BFS traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[] {i,j});
                } else {
                    matrix[i][j] = -1;
                }
            }
         }
    
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int dist = 1;
        
        // Traversing the given matrix using BFS 
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = queue.poll();
                // find all neighbors of the node polled from the queue
                for (int[] dir: dirs) {
                    int row = dir[0] + cur[0];
                    int col = dir[1] + cur[1];
                    // check if each of the valid coordinates neighbor node has a value of -1. If yes, implies that there was a 1 originally, so distance value should be updated for the polled node in current iteration. Also, the new 
                    if (row >= 0 && row < m && col >= 0 && col < n && matrix[row][col] == -1) {
                        matrix[row][col] = dist;
                        queue.add(new int[]{row,col});
                    }      
                }
            }
            dist++;
        }
        
        return matrix;
        
    }
}