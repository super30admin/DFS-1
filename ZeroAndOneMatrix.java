
// Time complexity : O(m*n)
// Space complexity : O(m*n)
import java.util.*;

public class ZeroAndOneMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] updatedMatrix = updateMatrix(matrix);
        for (int i = 0; i < updatedMatrix.length; i++) {
            for (int j = 0; j < updatedMatrix[0].length; j++) {
                System.out.print(updatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1) {
                        matrix[nr][nc] = dist;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }
            dist++;
        }

        return matrix;
    }

}
