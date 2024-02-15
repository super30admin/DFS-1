import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // Tc: O(m*n) Sc: O(m*n)
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return mat;

        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                    result[i][j] = 0;
                }
            }
        }

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                    result[newX][newY] = result[x][y] + 1;
                    visited[newX][newY] = true;
                    queue.offer(new int[] { newX, newY });
                }
            }
        }

        return result;

    }
}