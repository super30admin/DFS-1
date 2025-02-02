// # Time Complexity: O(m * n) - Each cell is processed once in BFS.
// # Space Complexity: O(m * n) - Queue stores at most all elements in the worst case.
// # Leetcode: Yes

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && mat[nr][nc] == -1) {
                    q.add(new int[]{nr, nc});
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                }
            }
        }

        return mat;
    }
}
