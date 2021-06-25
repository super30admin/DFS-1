// Time Complexity : O(M*N) //all the nodes will be visited
// Space Complexity : O(M*N) //queue will have only one level elements that is max m*n/2 at leaf level.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. it is BFS approach. DFS will be complicated.
 * 2. starting the first level as all zero indexes, insert it to queue.
 * 3. all the neighbors will be the next level and level will be the distance to zero.
 * 4. it is BFS approach.
 */

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixBFS {
	public int[][] updateMatrix(int[][] mat) {

		Queue<Integer> queue = new LinkedList<>();
		int onecount = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					queue.add(i);
					queue.add(j);
				} else {
					mat[i][j] = -1;
					onecount++;
				}
			}
		}

		if (onecount == 0)
			return mat;

		int[][] adjArr = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
		int level=1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k = k + 2) {
				int r = queue.poll();
				int c = queue.poll();
				for (int m = 0; m < adjArr.length; m++) {
					int nr = r + adjArr[m][0];
					int nc = c + adjArr[m][1];
					if (nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc]==-1) {
							mat[nr][nc]=level;
							queue.add(nr);
							queue.add(nc);
					}
				}
			}
			level++;
		}

		return mat;
	}

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1,1,1 } };
		new ZeroOneMatrixBFS().updateMatrix(mat);
	}
}
