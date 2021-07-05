import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m * n)  [iterating over each element in matrix]
// Space Complexity : O(m * n)  [size of queue for bfs]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// make all the existing to to -1 (to make sure we have not visited, as positive values will be visited ones)
// and add all 0 index into queue for starting bfs

class ZeroOneMatrixSolution {
    public int[][] updateMatrix(int[][] mat) {
        // null check
        if (mat == null || mat.length == 0)
            return mat;

        // make existing 1 to -1
        // get the indexes of all the zeros (to start the bfs)
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    r.add(i);
                    c.add(j);
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int dist = 1;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        // bfs from 0
        while (!r.isEmpty()) {
            int size = r.size();
            for (int i = 0; i < size; i++) {
                int cr = r.poll();
                int cc = c.poll();
                for (int[] dir : dirs) {
                    int nr = cr + dir[0];
                    int nc = cc + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                        mat[nr][nc] = dist;
                        r.add(nr);
                        c.add(nc);
                    }
                }

            }
            dist++;
        }

        return mat;
    }
}