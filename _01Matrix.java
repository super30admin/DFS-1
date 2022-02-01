// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class _01Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
                else {
                    matrix[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];

                if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == -1) {
                    queue.add(new int[] {x, y});
                    matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
                }
            }
        }

        return matrix;
    }
}
