import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity of the algorithm is O(m*n) where n is no. of rows and n is no. of column.
 * space Complexity is  O(m*n) where n is no. of rows and n is no. of column.
 */

public class ZeroOne01Matrix {

	public int[][] updateMatrix(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return matrix;

		int m = matrix.length, n = matrix[0].length;
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (matrix[i][j] == 0) {
					q.add(new int[] { i, j });
				} else {

					matrix[i][j] = -1;
				}

			}

		}

		int count = 1;

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {

				int[] curr = q.poll();

				for (int[] dir : dirs) {

					int r = curr[0] + dir[0];
					int c = curr[1] + dir[1];

					if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1) {

						matrix[r][c] = count;
						q.add(new int[] { r, c });
					}

				}

			}
			count++;
		}

		return matrix;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
