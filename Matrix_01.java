// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Add all the indices of elements in queue which are 0, else make other elements as -1 in the matrix
 * By traversing all 4 neighbors of all the nodes using size variable, if they are -1, then update the value to distance variable and add it to the queue
 * In the end, return the matrix */

import java.util.*;
public class Matrix_01 {
	public int[][] updateMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return matrix;

		Queue<int []> q = new LinkedList<>();
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j] == 0)
					q.add(new int[] {i,j}); //adding all zeros position to queue
				else
					matrix[i][j] = -1;   // if not zero, make them -1 so that we don't have to maintain visited array and can keep track of visited nodes using the updated distance value
			}
		}

		int dirs[][] = {{0,1}, {0,-1}, {-1,0}, {1,0}};
		int distance = 1;
		while(!q.isEmpty()){
			int size = q.size();
			for(int i=0; i<size; i++){
				int[] curr = q.poll();
				for(int[] dir: dirs){
					int r = curr[0] + dir[0];
					int c = curr[1] + dir[1];
					if(r >= 0 && r < matrix.length && c >= 0  && c < matrix[0].length && matrix[r][c] == -1) {  // checking bounds and if value is -1 i.e unvisited
						matrix[r][c] = distance;    //making equal to distance based on level
						q.add(new int[] {r,c});
					}
				}
			}
			distance++; //incrementing distance level  wise
		}
		return matrix;
	}
}
