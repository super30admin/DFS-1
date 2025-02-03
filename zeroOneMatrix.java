import java.util.LinkedList;
import java.util.Queue;
//Time complexity : O(m*n)
//Space Complexity  : O(m*n)

class zeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null) {
            return new int[][] {};
        }
        int m = mat.length;
        int n = mat[0].length;
        int lvl = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                } else {
                    q.add(new int[] { i, j });
                }

            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nc >= 0 && nc < n && nr >= 0 && nr < m && mat[nr][nc] == -1) {
                        q.add(new int[] { nr, nc });
                        mat[nr][nc] = lvl + 1;
                    }
                }
            }
            lvl++;
        }
        return mat;
    }
}