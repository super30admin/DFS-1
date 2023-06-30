import java.util.Queue;
import java.util.LinkedList;

public class NearestZeroOneMatrixBFS {


        public int[][] updateMatrix(int[][] mat) {

            int m = mat.length; int n = mat[0].length;

            if(mat == null || m == 0) return mat;

            Queue<int[]> queRCarr = new LinkedList<>();

            // add row-col having zero to queue, set ones to -1 to avoid conflict with distance value (if 1)
            for(int i = 0; i < m; i++) {

                for(int j = 0; j < n; j++) {

                    if(mat[i][j] == 0) {

                        queRCarr.add(new int[] {i,j});
                    }
                    else {

                        mat[i][j] = -1;
                    }
                }
            }

            int[][] dirFour = {{0,1}, {0,-1}, {1,0}, {-1,0}};

            int nearestDist = 1;

            // BFS while queue is not empty
            while(!queRCarr.isEmpty()) {

                int sizeQ = queRCarr.size();

                // iterate for a level
                for(int i = 0; i < sizeQ; i++) {

                    // pop out an array from queue
                    int[] popRC = queRCarr.poll();

                    for(int[] dir: dirFour) {

                        // find neighbors in four directions for every popped array in a level
                        int nRow = popRC[0] + dir[0];
                        int nCol = popRC[1] + dir[1];

                        // if in bounds, element 1 (-1) is found
                        if(nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && mat[nRow][nCol] == -1) {

                            // update nearest distance of one to zero
                            mat[nRow][nCol] = nearestDist;

                            // add row-col of one whose nearest distance is updated to queue
                            queRCarr.add(new int[] {nRow, nCol});
                        }

                    }
                }
                // increase nearest distance after each level
                nearestDist++;
            }
            // output updated mat with nearest zero distance values in place of ones
            return mat;
        }


}

/* Time Complexity = O(m*n)
Space Complexity = O(m*n) */
