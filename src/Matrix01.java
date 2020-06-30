// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * 
 * https://leetcode.com/problems/01-matrix/
 *
 */
public class Matrix01 {
	public int[][] updateMatrix(int[][] matrix) {
		Queue<int[]> q = new LinkedList<>();

		int m = matrix.length, n = matrix[0].length;

		//put all 0 in the queue for processing, mark all 1 as -1 so we dont confuse between value
		//1 and distance 1
		for(int i=0; i<m ;i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j] == 0) {
					q.add(new int[] {i,j});
				}else {
					matrix[i][j] = -1;
				}
			}
		}

		int[][] dirs = {{-1,0}, {1,0}, {0,-1},{0,1}};
		int dist = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			dist++;

			while(size > 0) {
				size--;
				int[] loc = q.poll();

				for(int[] dir: dirs) {
					int row = loc[0] + dir[0];
					int col = loc[1] + dir[1];

					//if current node value = -1, changes its value by current dist, add loc to queue
					if(row >=0 && row < m && col >=0 && col < n && matrix[row][col] == -1) {
						matrix[row][col] = dist;
						q.add(new int[] {row, col});
					}
				}
			}
		}

		return matrix;
	}
}
