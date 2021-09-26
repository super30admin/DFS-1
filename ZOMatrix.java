import java.util.*;

public class ZOMatrix {

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null)
            return mat;

        Queue<int[]> qu = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        // travers and find the zeros
        for (int i = 0; i < m; m++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    qu.add(new int[] { i, j });
                else
                    mat[i][j] = -1;
            }
        }

        // treverse and replace with distances

        int dist = 1;
        int[][] dir = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int[] curr = qu.poll();
                for (int j = 0; j < dir.length; j++) {
                    int r = dir[j][0] + curr[0];
                    int c = dir[j][1] + curr[1];

                    if (r > -1 && c > -1 && r < m && c < n && mat[r][c] == -1) {
                        mat[r][c] = dist;
                        qu.add(new int[] { r, c });
                    }
                }
            }
            dist++;
        }

        return mat;
    }

}
