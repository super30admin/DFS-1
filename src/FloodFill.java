import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity of the algorithm is O(m*n) where n is no. of rows and n is no. of column.
 * space Complexity is  O(m*n) where n is no. of rows and n is no. of column.
 */

public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		if (image == null || image.length == 0 || image[sr][sc] == newColor)
			return image;

		int m = image.length, n = image[0].length;
		Queue<int[]> q = new LinkedList<>();
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

		int previousColor = image[sr][sc];
		image[sr][sc] = newColor;
		q.add(new int[] { sr, sc });

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {

				int[] curr = q.poll();

				for (int[] dir : dirs) {

					int r = dir[0] + curr[0];
					int c = dir[1] + curr[1];

					if (r >= 0 && r < m && c >= 0 && c < n && image[r][c] == previousColor) {

						image[r][c] = newColor;

						q.add(new int[] { r, c });

					}

				}

			}

		}

		return image;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FloodFill objIn = new FloodFill();

	}

}
