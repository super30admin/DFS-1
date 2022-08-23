import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//542. 01 Matrix (Medium) - https://leetcode.com/problems/01-matrix/
class Solution {
	public int[][] updateMatrix(int[][] mat) {
		// Time Complexity : O(m*n), Space Complexity : O(m*n)
		if (mat == null || mat.length == 0)
			return mat;

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int m = mat.length, n = mat[0].length;

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					mat[i][j] = -1;
				} else {
					queue.add(new int[] { i, j });
				}
			}
		}

		if (queue.size() == m * n || queue.size() == 0)
			return mat;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();

			for (int[] dir : dirs) {
				int row = curr[0] + dir[0];
				int column = curr[1] + dir[1];

				if (row >= 0 && row < m && column >= 0 && column < n && mat[row][column] == -1) {
					queue.add(new int[] { row, column });
					mat[row][column] = mat[curr[0]][curr[1]] + 1;
				}
			}
		}

		return mat;
	}
}