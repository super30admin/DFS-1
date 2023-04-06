/*
 * The time complexity of this implementation is O(mn)
 * time complexity is O(mn)*/
import java.util.LinkedList;
import java.util.Queue;

public class Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize distance matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                if (r < 0 || r >= rows || c < 0 || c >= cols) {
                    continue;
                }

                if (dist[r][c] > dist[curr[0]][curr[1]] + 1) {
                    dist[r][c] = dist[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        return dist;
    }
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},
                {0,1,0},
                {1,1,1}};

        Matrix sol = new Matrix();
        int[][] dist = sol.updateMatrix(mat);

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

}
