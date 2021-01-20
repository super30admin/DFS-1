// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : YES
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return matrix;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int coord[] = q.poll();
            int x = coord[0];
            int y = coord[1];
            int min = matrix[x][y];
            for (int dir[] : new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }) {
                int i = x + dir[0];
                int j = y + dir[1];
                if (i >= 0 && j >= 0 & i < m && j < n && !visited[i][j]) {
                    matrix[i][j] = min + 1;
                    visited[i][j] = true;
                    q.add(new int[] { i, j });
                }
            }
        }

        return matrix;
    }
}
