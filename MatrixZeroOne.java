// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int m;
    int n;
    int[][] dirs;

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        // R D L U
        dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // helperBfs(mat)
        // return mat;
        return helperDfsRecursion(mat);
    }

    private int[][] helperDfsRecursion(int[][] mat) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }

        int [][]result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    result[i][j] = dfs(mat, i, j, m, n, result);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] mat, int r, int c, int m, int n, int [][] result) {

        // D
        if (r < m - 1 && mat[r + 1][c] == 0) {
            return 1;
        }
        // R
        if (c < n - 1 && mat[r][c + 1] == 0) {
            return 1;
        }
        // T
        if (r > 0 && mat[r - 1][c] == 0) {
            return 1;
        }

        // L
        if (c > 0 && mat[r][c - 1] == 0) {
            return 1;
        }

        int top = 99999;
        int bottom = 99999;
        int left = 99999;
        int right = 99999;

        // top
        if (r > 0 && result[r - 1][c] != 0) {
            top = result[r - 1][c];
        }

        // left
        if (c > 0 && result[r][c - 1] != 0) {
            left = result[r][c - 1];
        }

        // Bottom
        if (r < m - 1) {
            if (result[r + 1][c] == 0) {
                result[r + 1][c] = dfs(mat, r + 1, c , m, n, result);
            }
            
            bottom = result[r + 1][c];
        }

        // right
        if (c < n - 1) {
            if (result[r][c + 1] == 0) {
                result[r][c + 1] = dfs(mat, r, c + 1, m, n, result);
            }
            right = result[r][c + 1];
        }

        return Math.min(top, Math.min(bottom, Math.min(left, right))) + 1;
    }

    private void helperBfs(int[][] mat) {
        Queue<Integer> q = new LinkedList<>();

        int offSet = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(i);
                    q.offer(j);
                } else {
                    mat[i][j] = offSet;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i += 2) {
                int r = q.poll();
                int c = q.poll();

                for (int dir[] : dirs) {
                    int nr = dir[0] + r;
                    int nc = dir[1] + c;

                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == offSet) {
                        mat[nr][nc] = mat[r][c] + 1;
                        q.offer(nr);
                        q.offer(nc);
                    }
                }
            }
        }
    }
}