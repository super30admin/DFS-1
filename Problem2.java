// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        // edge case
        if (mat == null || m == 0)
            return mat;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE; //
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[curr[0]][curr[1]] + 1) {
                        q.add(new int[] { r, c });
                        mat[r][c] = mat[curr[0]][curr[1]] + 1;
                    }
                }
            }
        }
        return mat;
    }
}
