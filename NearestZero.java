import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

/*
LeetCode 542. 01 Matrix (Nearest Zero)
Given an m x n binary matrix mat, return a matrix where each cell contains the distance
to the nearest 0
Two BFS-based approaches:

APPROACH 1 (Brute Force BFS from each 1)
- For every cell that is 1, run BFS until you find a 0.
- Correct but slow because BFS repeats many times.

Time Complexity: O((m*n) * (m*n)) = O((m*n)^2) worst-case
Space Complexity: O(m*n) for visited + queue per BFS

APPROACH 2 (Optimal Multi-source BFS)
- Put all zeros into a queue initially (all as BFS sources).
- Distances for zeros are 0.
- BFS expands outward; first time we reach a cell is its shortest distance to a zero.

Time Complexity: O(m*n)
Space Complexity: O(m*n)
*/
public class NearestZero {

    private int[][] dirs;
    private int m, n;

    // -------------------- Approach 1: BFS from each '1' cell (Brute Force) --------------------
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) return mat;

        this.m = mat.length;
        this.n = mat[0].length;
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // For each 1, run BFS to find nearest 0 and overwrite the cell with the distance
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = bfs(mat, i, j);
                }
            }
        }
        return mat;
    }

    // BFS that starts from one cell (i, j) that is 1 and returns distance to nearest 0
    private int bfs(int[][] mat, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        boolean[][] visited = new boolean[m][n];
        visited[i][j] = true;

        int dist = 1;

        // Standard level-order BFS: each layer increases distance by 1
        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();

                for (int[] d : dirs) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        // If we reach a 0, dist is the shortest distance because BFS expands by layers
                        if (mat[r][c] == 0) return dist;

                        // Otherwise keep expanding through unvisited cells
                        if (!visited[r][c]) {
                            visited[r][c] = true;
                            q.add(new int[]{r, c});
                        }
                    }
                }
            }
            dist++;
        }

        return -1; // should not happen if at least one zero exists in matrix
    }

    public int[][] updateMatrixMultiSourceBFS(int[][] mat) {
        if (mat == null || mat.length == 0) return mat;

        int m = mat.length, n = mat[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> q = new LinkedList<>();

        // Initialize:
        // - enqueue all zeros
        // - mark ones as -1 (unvisited)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        // BFS expanding from all zeros
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                    // First time reaching this cell => shortest distance
                    mat[nr][nc] = mat[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return mat;
    }

    // Simple main method to test (no assertions)
    public static void main(String[] args) {
        NearestZero solver = new NearestZero();

        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        System.out.println("Original:");
        print(mat);
        int[][] mat1 = copy(mat);
        System.out.println("\nApproach 1 (BFS from each 1):");
        print(solver.updateMatrix(mat1));
        int[][] mat2 = copy(mat);
        System.out.println("\nApproach 2 (Multi-source BFS):");
        print(solver.updateMatrixMultiSourceBFS(mat2));
    }

    private static int[][] copy(int[][] a) {
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, res[i], 0, a[0].length);
        }
        return res;
    }

    private static void print(int[][] a) {
        for (int[] row : a) {
            System.out.println(Arrays.toString(row));
        }
    }
}
