import java.util.LinkedList;
import java.util.Queue;

public class NearestZeroDistance {
    private static final int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // Up, Down, Left, Right

    public int[][] nearestZeroDistance(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] distances = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all cells containing 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        // Perform BFS to find the distance of each cell to the nearest 0
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    distances[newRow][newCol] = distances[row][col] + 1;
                    visited[newRow][newCol] = true;
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };

        NearestZeroDistance solution = new NearestZeroDistance();
        int[][] distances = solution.nearestZeroDistance(mat);

        // Print the result
        for (int[] row : distances) {
            for (int distance : row) {
                System.out.print(distance + " ");
            }
            System.out.println();
        }
    }
}
