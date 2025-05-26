/*
BFS - more optimised than DFS, use bfs when looking for shortest path and dfs when looking for all possible solutions

TC - O(m * n)
SC - O(m * n)
 */

 class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) return mat;
        
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        // Step 1: Initialize queue and mark 1s as unvisited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                if (r >= 0 && r < m && c >= 0 && c < n &&
                    mat[r][c] > mat[curr[0]][curr[1]] + 1) {
                    mat[r][c] = mat[curr[0]][curr[1]] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }

        return mat;
    }
}