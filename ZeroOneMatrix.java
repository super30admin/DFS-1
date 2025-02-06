import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Using BFS and capturing independent cells in a queue first.
 * Perform BFS for all the independent cells and increase the level of neighbors
 */

public class ZeroOneMatrix {
    // ---------------------------------------------------------- BFS Approach ------------------------------------------------------------------
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> q = new LinkedList<>();

        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else {
                    mat[i][j] = -mat[i][j];
                }
            }
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                        q.add(new int[] { nr, nc });
                        mat[nr][nc] = level + 1;
                    }
                }
            }
            level++;
        }
        return mat;
    }

    public static void main(String[] args) {
        // Your code here
        ZeroOneMatrix obj = new ZeroOneMatrix();
        int[][] mat = {
            {0,0,1},
            {1,1,1},
            {1,0,1}
        };
        obj.updateMatrix(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}