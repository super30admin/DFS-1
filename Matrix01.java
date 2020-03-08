
// Time Complexity :O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.*;

public class Matrix01 {

	private int[][] updateMatrix(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return matrix;
		int m = matrix.length, n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					visited[i][j] = true;
					q.add(new int[] { i, j });
				}
			}
		}

		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int distance = 0;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				matrix[curr[0]][curr[1]] = distance;
				for (int[] dir : dirs) {
					int r = curr[0] + dir[0];
					int c = curr[1] + dir[1];

					if (r >= 0 && r < m && c >= 0 && c < n && visited[r][c] == false) {
						visited[r][c] = true;
						q.add(new int[] { r, c });
					}

				}
			}
			distance++;

		}
		return matrix;
	}

	public static void main(String[] args) {

		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		Matrix01 m = new Matrix01();
		m.updateMatrix(matrix);

	}

}
