public class NearestzeroOneMatrixDFSBrute {


        public int[][] updateMatrix(int[][] mat) {

            // DFS - brute force

            int m = mat.length; int n = mat[0].length;

            int[][] res = new int[m][n];

            for(int i = 0; i < m; i++) {

                for(int j = 0; j < n; j++) {

                    if(mat[i][j] == 1) {

                        mat[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            // DFS from each zero
            for(int i = 0; i < m; i++) {

                for(int j = 0; j < n; j++) {

                    if(mat[i][j] == 0) {

                        dfsOnZero(mat, i, j, m, n, 0);
                    }
                }
            }
            return mat;
        }

        private void dfsOnZero(int[][] mat, int i, int j, int m, int n, int nrDist) {


            //logic

            mat[i][j] = nrDist;

            int[][] dirFour = {{1,0}, {0,1}, {-1,0}, {0,-1}};

            for(int[] dir: dirFour) {

                int nr = dir[0] + i;
                int nc = dir[1] + j;

                //make distance of every one from the zero on which DFS is called and to which it is connected
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] > nrDist) {

                    // zero here is equivalent to rotten orange
                    dfsOnZero(mat, nr, nc, m, n, nrDist + 1);
                }
            }
        }

}
