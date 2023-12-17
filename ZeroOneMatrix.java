import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    int[][] dirs;
    int m;
    int n;
    public int[][] updateMatrix(int[][] mat) {
        this.dirs  = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        this.m = mat.length;
        this.n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] = 10000;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dfs(mat, i,j);
                }
            }
        }

        return mat;
    }

    private void dfs(int[][] mat, int i, int j){
        //base
        if(i < 0 || i >= m || j < 0|| j >= n  ){
            return;
        }

        //logic
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[i][j]+1){
                mat[r][c] = mat[i][j]+1;
                dfs(mat, r, c);
            }
        }
    }

    public int[][] updateMatrix2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        // Enqueue all 0 cells and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[curr[0]][curr[1]]+1) {
                    mat[r][c] = mat[curr[0]][curr[1]] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }

        return mat;
    }
}
