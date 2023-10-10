import java.util.Queue;

public class Matrix_01 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new java.util.LinkedList<>();
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int level = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                for (int[] dir : dirs) {
                    int nr = current[0] + dir[0];
                    int nc = current[1] + dir[1];
                    if (nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length && mat[nr][nc] == -1) {
                        q.add(new int[] { nr, nc });
                        mat[nr][nc] = level + 1;
                    }
                }

            }
            level++;
        }

        return mat;
    }
}
