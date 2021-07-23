//Time Complexity : O(m*n), m -> Total number of rows is the matrix, n -> Total number of columns in the matrix
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	/*
	 * Perform BFS, starting with each element with value 0, to find the minimum
	 * distance of 0 from each 1.
	 */
	public int[][] updateMatrix(int[][] mat) {
		if (mat == null || mat.length == 0) {
			return new int[0][0];
		}

		int m = mat.length;
		int n = mat[0].length;
		int[][] dist = new int[m][n];
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		Queue<int[]> queue = new LinkedList<int[]>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					dist[i][j] = 0;
					queue.add(new int[] { i, j });
				} else {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] pair = queue.poll();

			for (int[] dir : dirs) {
				int r = pair[0] + dir[0];
				int c = pair[1] + dir[1];

				if (r >= 0 && r < m && c >= 0 && c < n) {
					if (dist[r][c] > dist[pair[0]][pair[1]] + 1) {
						dist[r][c] = dist[pair[0]][pair[1]] + 1;
						queue.add(new int[] { r, c });
					}
				}
			}
		}
		return dist;
	}

	/*
	 * Perform BFS, starting with each element with value 0, to find the minimum
	 * distance of 0 from each 1. This is done in-place.
	 */
	public int[][] updateMatrixInPlace(int[][] mat) {
		if (mat == null || mat.length == 0) {
			return new int[0][0];
		}

		int m = mat.length;
		int n = mat[0].length;
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		Queue<int[]> queue = new LinkedList<int[]>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					queue.add(new int[] { i, j });
				} else {
					mat[i][j] = -1;
				}
			}
		}

		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int[] pair = queue.poll();
				for (int[] dir : dirs) {
					int r = pair[0] + dir[0];
					int c = pair[1] + dir[1];

					if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1) {
						mat[r][c] = mat[pair[0]][pair[1]] + 1;
						queue.add(new int[] { r, c });
					}
				}
			}

		}
		return mat;
	}

	public void print(int[][] mat) {
		for (int[] rows : mat) {
			for (int val : rows) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Matrix01 obj = new Matrix01();
		int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int[][] dist = obj.updateMatrixInPlace(mat);

		System.out.println("Distance Array:");
		obj.print(dist);
	}

}
