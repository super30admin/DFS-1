// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] result = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all 0s to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        // 4 directions
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int distance = 0;

        // Step 2: BFS from all 0s
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++; // Increase distance level

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        !visited[newRow][newCol] && mat[newRow][newCol] == 1) {
                        result[newRow][newCol] = distance;
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return result;
    }
}
