//Time complexity is O(m*n) i.e row*column.
//Space complexity is O(m*n) i.e row*column elements in queue.
//This solution is submitted on leetcode

import java.util.LinkedList;
import java.util.Queue;

public class BigN63NearestDistance01MatrixUsingBFSLevel {
	class Solution {
		public int[][] updateMatrix(int[][] matrix) {
			int row = matrix.length;
			int column = matrix[0].length;
			// edge case
			if (row == 0)
				return matrix;
			Queue<int[]> q = new LinkedList<>();
			// filling the queue
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (matrix[i][j] == 0)
						q.add(new int[] { i, j });
				}
			}
			int dist = 1;
			int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] temp = q.poll();
					for (int[] dir : dirs) {
						int r = temp[0] + dir[0];
						int c = temp[1] + dir[1];
						if (r >= 0 && r < row && c >= 0 && c < column && matrix[r][c] == 1) {
							matrix[r][c] = -dist;
							q.add(new int[] { r, c });
						}
					}
				}
				dist++;
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					matrix[i][j] *= -1;
				}
			}
			return matrix;
		}
	}
}
