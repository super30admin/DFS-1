import java.util.Arrays;

/**
 * LeetCode: https://leetcode.com/problems/01-matrix/
 *
 * Approach:
 * This implementation uses Depth-First Search (DFS) to update each cell in the matrix with the distance to the nearest 0.
 * First, all 1s are marked as -1 to indicate they are unvisited. Then, for each 0 cell, DFS is performed to update the distance of all reachable -1 cells or cells with a greater distance.
 * The DFS propagates the distance from each 0 to its neighbors, updating only if the neighbor is unvisited or can be reached with a shorter distance.
 *
 * Time Complexity: O((m * n)^2) in the worst case, where m is the number of rows and n is the number of columns. Each cell can be visited multiple times due to overlapping DFS traversals.
 * Space Complexity: O(m * n) in the worst case due to the recursion stack if the entire matrix is filled with 1s except for a single 0.
 */

public class ZeroOneMatrixDFS {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) mat[i][j] = -1;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    dfs(mat, i, j, 1);
                }
            }
        }
        return mat;
    }

    private void dfs(int[][] mat, int cr, int cc, int dist) {

        for (int[] dir : dirs) {
            int r = dir[0] + cr;
            int c = dir[1] + cc;

            if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && (mat[r][c] == -1 || mat[r][c] > dist)) {
                mat[r][c] = dist;
                dfs(mat, r, c, dist + 1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new ZeroOneMatrixDFS().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
}
