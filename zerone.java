// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++) 
				if (matrix[i][j] == 0) 
                    q.add(new int[] { i, j });
				else 
                    matrix[i][j] = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int[] top = q.remove();
			for (int[] dir : dirs) {
				int x = top[0] + dir[0];
				int y = top[1] + dir[1];
				if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) continue;
				if (matrix[x][y] <= matrix[top[0]][top[1]] + 1) continue;
				matrix[x][y] = matrix[top[0]][top[1]] + 1;
				q.add(new int[] { x, y });
			}
		}
		return matrix;
	}
}