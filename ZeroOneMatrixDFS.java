// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes but time out exception , Not optimal
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// DFS approach
// 1. Mark all 1s as unvisited (-1)
// 2. Start DFS from every 0 and update distance for unvisited 1s
// 3. If we encounter a visited 1, we update distance if current distance is smaller than existing distance
//  4. Return the matrix after processing all 0s
// Note: This approach is not optimal as we are doing DFS from every 0 and updating distance for all reachable 1s. Hence, it can lead to time out exception for large matrices. Optimal approach is BFS which we have implemented in ZeroOneMatrixBFS.java
import java.util.*;

class ZeroOneMatrixDFS {

    int[][] directions = new int[][]
    {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        // Mark all 1s as unvisited (-1)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }

        // Start DFS from every 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    helper(mat, i, j, 1);
                }
            }
        }

        return mat;
    }

    public void helper(int[][] mat, int row, int col, int dist) {

        for (int[] dir : directions) {

            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nr < mat.length &&
                nc >= 0 && nc < mat[0].length &&
                (mat[nr][nc] == -1 || mat[nr][nc] > dist)) {

                mat[nr][nc] = dist;

                helper(mat, nr, nc, dist + 1);
            }
        }
    }
}