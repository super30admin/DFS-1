import java.util.*;

//SC is O(mxn)
//TC is O(mxn)
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        if (mat == null || mat.length == 0) {
            return mat;
        }

        Queue<int[]> q = new LinkedList<>();

        int level = 1;
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                // now we check for uplr using dir array
                int[] value = q.poll();

                for (int[] dir : dirs) {
                    int nr = value[0] + dir[0];
                    int nc = value[1] + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (mat[nr][nc] < 0) {
                            q.add(new int[] { nr, nc });
                            mat[nr][nc] = level;
                        }
                    }
                }

            }

            level++;
        }

        return mat;

    }
}