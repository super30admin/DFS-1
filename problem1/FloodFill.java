//Time Complexity : O(m*n), m -> Total number of rows is the image, n -> Total number of columns in the image
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	/* Perform BFS until all pixels have been colored with new color */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int m = image.length;
		int n = image[0].length;

		if (m == 0) {
			return new int[0][0];
		}
		int startColor = image[sr][sc];
		if (startColor == newColor) {
			return image;
		}

		Queue<Pair> queue = new LinkedList<Pair>();
		int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

		image[sr][sc] = newColor;
		queue.add(new Pair(sr, sc));

		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int row = p.row;
			int col = p.col;

			for (int i = 0; i < dirs.length; i++) {
				int nextRow = row + dirs[i][0];
				int nextCol = col + dirs[i][1];

				if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n
						&& image[nextRow][nextCol] == startColor) {
					image[nextRow][nextCol] = newColor;
					queue.add(new Pair(nextRow, nextCol));
				}
			}
		}
		return image;
	}

	public void print(int[][] image) {
		for (int[] rows : image) {
			for (int val : rows) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		FloodFill obj = new FloodFill();
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int row = 1;
		int col = 1;
		int newColor = 2;
		int[][] newImage = obj.floodFill(image, row, col, newColor);
		obj.print(newImage);
	}

}
