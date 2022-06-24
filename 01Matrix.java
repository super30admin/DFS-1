// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    public static int[][] updateMatrix(int[][] matrix) {
        // null case
        if (matrix.length == 0)
            return matrix;
        int m = matrix.length;
        int n = matrix[0].length;

        // direction array
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        // queue for bfs
        Queue<int[]> q = new LinkedList<>();

        // initially I put all the 0s index in queue
        // I am also marking the node with -1 so when I change with its distance I am
        // not going to visit again.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty()) {
            // get first zero index and find all the neighbours with -1s
            int[] cur = q.poll();
            for (int[] dir : dirs) {

                // get neighbouring rows and cols
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                // check bounds
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    // if we found -1 that means that is oue element so I can get its distance from
                    // current index distance + 1
                    if (matrix[nr][nc] == -1) {
                        matrix[nr][nc] = matrix[cur[0]][cur[1]] + 1;
                        q.add(new int[] { nr, nc });
                    }

                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };
        int[][] result = updateMatrix(matrix);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));

        }
    }
}