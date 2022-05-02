import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    //BFS
    // TC : O (m * n)
    // SC : O (m * n)
    // where m is raw and n is column
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null) return mat;

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> que = new LinkedList<>();
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    que.add(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }
        int lvl = 1;
        while (!que.isEmpty()) {
            // int size = que.size();
            // for (int j= 0 ; j < size ; j++){
            int[] curr = que.poll();
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1) {
                    mat[r][c] = mat[curr[0]][curr[1]] + 1;
                    que.add(new int[]{r, c});
                }
            }
            // }
            lvl++;
        }
        return mat;
    }
}
