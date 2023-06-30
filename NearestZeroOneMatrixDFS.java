public class NearestZeroOneMatrixDFS {


        public int[][] updateMatrix(int[][] mat) {

            int m = mat.length; int n = mat[0].length;

            int[][] res = new int[m][n];

            for(int i = 0; i < m; i++) {

                for(int j = 0; j < n; j++) {

                    res[i][j] = dfs(mat, res, i, j, m, n);
                }
            }

            return res;
        }

        private int dfs(int[][] mat, int[][] res, int i, int j, int m, int n) {

            //
            if(i < 0 || j < 0 || i >= m || j >= n) return 9999;
            //
            if(mat[i][j] == 0) return 0;

            //
            if((i > 0 && mat[i-1][j] == 0) || (j > 0 && mat[i][j-1] == 0) || (i < m-1 && mat[i+1][j] == 0) || (j < n-1 && mat[i][j+1] == 0)){

                return 1;
            }

            int top, bottom, left, right;

            left = top = 9999;
            //
            if(i > 0 && res[i-1][j] != 0) {

                top = res[i-1][j];
            }

            if(j > 0 && res[i][j-1] != 0) {

                left = res[i][j-1];
            }

            bottom = dfs(mat, res, i+1, j, m, n);
            right = dfs(mat, res, i, j+1, m, n);

            return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1;
        }

}
