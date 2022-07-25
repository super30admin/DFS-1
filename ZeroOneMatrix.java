import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0)
            return mat;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) { // traversing the matrix and adding all the cells with 0(independant) to Queue.
                    q.add(new int[] { i, j });
                } else {
                    mat[i][j] = -1; // if the cell holds 1, making it -1 to avoid adding duplicates to the Queue.
                }
            }
        }

        int dist = 1; // is used to find the distance and keeps increasing wrt the level of the Queue.
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) { // after zeros, only adding -1
                                                                                       // cells to Queue
                        q.add(new int[] { nr, nc });
                        mat[nr][nc] = dist;
                    }
                }
            }
            dist++; // incrementing the distance by 1 after each level
        }
        return mat;
    }
}