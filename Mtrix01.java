import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//Time Complexity : O(M*N)
//Space Complexity : O(M*N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Apply BFS. Store all indices where 0 is present. From there we have to 
 * calculate the distance to 1s in the matrix. while storing in queue, add a 0
 * which is the distance to the current index. Increment it after every pop and push
 * it along with the adjacent nodes.
 *
 */
class Solution {
	public int[][] updateMatrix(int[][] mat) {
		int[][] result = new int[mat.length][mat[0].length];
		for (int i = 0; i < result.length; i++)
			Arrays.fill(result[i], Integer.MAX_VALUE);
		Queue<Integer[]> q = new LinkedList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					q.add(new Integer[] { i, j, 0 });
				}
			}
		}
		BFS(result, q);
		return result;
	}

	private void BFS(int[][] result, Queue<Integer[]> q) {
		int[][] visited = new int[result.length][result[0].length];
		while (!q.isEmpty()) {
			Integer[] cur = q.remove();
			int i = cur[0];
			int j = cur[1];
			int dist = cur[2];
			if (i < 0 || j < 0 || i >= result.length || j >= result[0].length) {
				continue;
			}
			if (visited[i][j] == 1) {
				continue;
			}
			visited[i][j] = 1;
			result[i][j] = Math.min(result[i][j], dist);
			dist++;
			q.add(new Integer[] { i - 1, j, dist });
			q.add(new Integer[] { i + 1, j, dist });
			q.add(new Integer[] { i, j - 1, dist });
			q.add(new Integer[] { i, j + 1, dist });
		}
	}
}