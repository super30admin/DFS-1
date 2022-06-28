// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//542. 01 Matrix
//https://leetcode.com/problems/01-matrix/

class Solution {
    // BFS approach
    // time: O(mxn)
    // space: O(mxn)
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    q.add(new int[] { i, j });
            }
        }

        int distance = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int r = 0;
                int c = 0;
                int count = 0;
                for (int k : q.peek()) {
                    if (count == 0)
                        r = k;
                    if (count == 1)
                        c = k;
                    count++;
                }
                for (int[] dir : dirs) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if ((row >= 0 && col >= 0 && row < m && col < n) && (matrix[row][col] == 1)) {
                        if (distance == 1) {
                            matrix[row][col] = -1;
                            q.add(new int[] { row, col });
                        } else {
                            matrix[row][col] = distance;
                            q.add(new int[] { row, col });
                        }
                    }
                }
                q.remove();
            }
            distance++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 1;
            }
        }

        return matrix;
    }
}