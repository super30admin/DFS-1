
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill_BFS {

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		Solution s = new Solution();
		System.out.println(s.floodFill(mat, 1, 1, 2));

		print(mat);

	}

	private static void print(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}

class Solution {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int original_color = image[sr][sc];
		if (original_color == color)
			return image;

		Queue<int[]> q = new LinkedList<>();
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		image[sr][sc] = color;
		q.add(new int[] { sr, sc });

		while (!q.isEmpty()) {
			int[] idx = q.poll();
			for (int[] dir : directions) {
				int nr = dir[0] + idx[0];
				int nc = dir[1] + idx[1];

				if (nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length
						&& image[nr][nc] == original_color) {
					image[nr][nc] = color;
					q.add(new int[] { nr, nc });
				}
			}
		}
		return image;
	}
}
