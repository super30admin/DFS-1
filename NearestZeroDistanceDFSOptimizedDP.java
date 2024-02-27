public class NearestZeroDistanceDFSOptimizedDP {
    class Solution {
        private final int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        private final int[][] rightBottomDirs = { { 0, 1 }, { 1, 0 } };
        private final int[][] leftTopDirs = { { 0, -1 }, { -1, 0 } };
        private int[][] resultMat; // DP Matrix

        public int[][] updateMatrix(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;

            resultMat = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 1) {
                        resultMat[i][j] = dfs(mat, i, j);
                    }
                }
            }

            return resultMat;
        }

        private int dfs(int[][] mat, int row, int col) {
            for (int[] dir : dirs) {
                int currRow = row + dir[0];
                int currCol = col + dir[1];

                if (currRow >= 0 && currRow < mat.length && currCol >= 0 && currCol < mat[0].length) {
                    if (mat[currRow][currCol] == 0) {
                        return 1;
                    }
                }
            }

            int min = Integer.MAX_VALUE - 1;
            for (int[] dir : rightBottomDirs) {
                int currRow = row + dir[0];
                int currCol = col + dir[1];

                if (currRow < mat.length && currCol < mat[0].length) {
                    if (resultMat[currRow][currCol] == 0) {
                        resultMat[currRow][currCol] = dfs(mat, currRow, currCol);
                    }
                    min = Math.min(min, resultMat[currRow][currCol]);
                }
            }

            for (int[] dir : leftTopDirs) {
                int currRow = row + dir[0];
                int currCol = col + dir[1];

                if (currRow >= 0 && currCol >= 0) {
                    if (resultMat[currRow][currCol] != 0) { // Why this check
                        min = Math.min(min, resultMat[currRow][currCol]);
                    }
                }
            }

            return min + 1;
        }
    }
}
