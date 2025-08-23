// Time Complexity : O(m * n), m - rows, n - columns
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use BFS
// 2. Add all 0's to queue initially
// 3. Update 1 to -1 to differentiate the distance from matrix value
// 3. For all 0's in queue, explore all the 4 neighbors, if -1 is present in level 1, update -1 to 1
//      - add the row col index to queue to explore further
//      - each time, know the size of queue to determine the distance of 1 to 0.

import java.util.LinkedList;
import java.util.Queue;

class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    // Change 1 to -1 to differentiate the distance from matrix value
                    mat[i][j] = -1;
                }
                else {
                    q.add(new int[]{i, j});
                }
            }
        }

        int dist = 1;
        while(!q.isEmpty()) {

            int k = q.size();
            for(int i=0; i<k; i++) {
                int[] rc = q.remove();

                for(int j=0; j<dirs.length; j++) {
                    int r = dirs[j][0] + rc[0];
                    int c = dirs[j][1] + rc[1];

                    if(r >= 0 && c >= 0 && r < mat.length
                            && c < mat[0].length) {

                        if(mat[r][c] == -1) {
                            q.add(new int[]{r, c});
                            mat[r][c] = dist;
                        }
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}