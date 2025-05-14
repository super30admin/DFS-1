// Time Complexity:O(m*n);
// Space Complexity:O(m*n);
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                for (int[] dir : dirs) {
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                        res[r][c] = dist;
                        visited[r][c] = true;
                        q.offer(new int[]{r, c});
                    }
                }
            }
        }

        return res;
    }
}
