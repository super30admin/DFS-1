class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Initialize queue with all 0s and set 1s to a large number (unvisited)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE; // Mark unvisited 1s
                }
            }
        }

        // BFS to update distances
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0], nc = curr[1] + dir[1];

                // Only update if the neighbor is unvisited or has a larger distance
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] > mat[curr[0]][curr[1]] + 1) {
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return mat;
    }
}
