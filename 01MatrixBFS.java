// https://leetcode.com/problems/01-matrix/

// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length; // row
        int n = matrix[0].length; // column

        Queue<int[]> q = new LinkedList<>();

        int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    // we are replacing 1 with -1 as we can track
                    matrix[i][j] = -1;
                } else {
                    // adding queue array for all 0
                    q.add(new int[] { i, j });
                }
            }
        }

        if (q.size() == 0)
            return matrix;

        // making distance as 1 initially
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                // traversing through directions
                for (int[] dir : dirs) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    // bound checks
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1) {
                        matrix[nr][nc] = dist;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
            // increasing distance through each level
            dist++;
        }
        return matrix;
    }
}