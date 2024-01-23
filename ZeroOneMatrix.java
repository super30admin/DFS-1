import java.util.*;

public class ZeroOneMatrix {
    // TC: O(M * N) where M is number of rows and N is number of cols;
    // SC: O(1)
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] d : dirs) {
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];
                if (nx >= 0 && nx < mat.length && ny >= 0 && ny < mat[0].length && mat[nx][ny] == Integer.MAX_VALUE) {
                    mat[nx][ny] = mat[curr[0]][curr[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return mat;
    }
}
