/*
 * #542. 01 Matrix
 * 
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
 
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 

Note:

1. The number of elements of the given matrix will not exceed 10,000.
2. There are at least one 0 in the given matrix.
3. The cells are adjacent in only four directions: up, down, left and right.

 */


/*
 * Time Complexity: O (m*n) + O (N) -> O (m*n) - To traverse through all elements in a matrix, O (N) - while loop runs until queue is empty (N elements in a queue)
 * 
 * Space Complexity: O (N) -> 'N' elements are stored in a queue but not all at the same time
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 * 
 */

package com.s30.edu.DFS1;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	 public int[][] updateMatrix(int[][] matrix) {
	        
	        // #1. Base condition
	        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
	            return matrix;
	        }
	        
	        // #2. Create a queue using Linked List
	        Queue<int[]> queue = new LinkedList<>();
	        
	        // #3. Traverse through the matrix elements
	        for(int i = 0; i < matrix.length; i++){
	            for(int j = 0; j < matrix[0].length; j++){
	                // Add (i,j) of all 0's to queue -> initiate queue
	                // We will start BFS with 0 because its easier to find distance of a cell from 0 than to start at 1 and explore all 0's in matrix
	                if(matrix[i][j] == 0){
	                    queue.add(new int[]{i,j});
	                }
	                // Replace all 1's with infinity
	                // We will change the value at explored/valid branch only when previous cell value +  1 < current branch/cell value -> This condition will fail for 0 + 1 < 1, so we are replacing 1's with infinity 
	                else if(matrix[i][j] == 1){
	                    matrix[i][j] = Integer.MAX_VALUE;
	                }
	            }
	        }
	        
	        // #4. Global direction array to explore the branches/directions
	        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	        
	        
	        // #5. Start regular BFS/processing the queue
	        while(!queue.isEmpty()){
	            int[] front = queue.poll();
	            
	            // #6. Explore the directions from current cell
	            for(int[] dir : dirs){
	                
	                int i = front[0];
	                int j = front[1];
	                
	                int r = i + dir[0];
	                int c = j + dir[1];
	                
	                // #7. Check if the branch/direction is valid and value at current cell + 1 < value at new cell/branch
	                if(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[i][j] + 1 < matrix[r][c]){
	                    // If yes, update the value at next cell/branch
	                    matrix[r][c] = matrix[i][j] + 1;
	                    // Add location (i,j) of new cell/branch to queue 
	                    queue.add(new int[]{r,c});
	                }
	                
	            }
	            
	        }
	        return matrix; // return the manipulated matrix as output
	        
	    }
	 
}
