//time: O(N*M)
//Space:O(N)

class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return matrix;

        int n = matrix.length;
        int m = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[] { i, j });

                } else if (matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int i = front[0];
            int j = front[1];
            for (int dir[] : dirs) {
                int r = front[0] + dir[0];
                int c = front[1] + dir[1];

                if (r >= 0 && r < n && c >= 0 && c < m && (matrix[i][j] + 1 < matrix[r][c])) {
                    matrix[r][c] = matrix[i][j] + 1;
                    queue.add(new int[] { r, c });
                }

            }
        }

        return matrix;
    }
}