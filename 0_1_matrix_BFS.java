
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return matrix;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					q.add(new int[] { i, j });
				} else {
					matrix[i][j] = -1;
				}
			}
		}
		int distance = 1;
		int direction[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int curr[] = q.poll();
				for (int dir[] : direction) {
					int r = curr[0] + dir[0];
					int c = curr[1] + dir[1];
					if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] == -1) {
						matrix[r][c] = distance;
						q.add(new int[] { r, c });
					}
				}
			}
			distance++;
		}
		return matrix;
	}
}