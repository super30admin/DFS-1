
// TC - O(MN * MN)
// SC - O(MN)

public class NearestZeroDistanceDFS {
    class Solution {
        private final int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        public int[][] updateMatrix(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 1) {
                        mat[i][j] = -1;
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == -1) {
                        mat[i][j] = dfs(mat, i, j);
                    }
                }
            }

            return mat;
        }

        private int dfs(int[][] mat, int row, int col) {
            int min = Integer.MAX_VALUE;
            for (int[] dir : dirs) {
                int currRow = row + dir[0];
                int currCol = col + dir[1];

                if (currRow >= 0 && currRow < mat.length && currCol >= 0 && currCol < mat[0].length) {
                    if (mat[currRow][currCol] == 0) {
                        return 1;
                    }
                    min = Math.min(min, dfs(mat, currRow, currCol));
                }
            }

            return min + 1;
        }
    }
}
