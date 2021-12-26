// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach BFS

// We llop through the matrix and get all the nodes having value as 0 add them to the queue
// making 1s to -1
// We pop the queue and then add all the nodes having -1 to the queue and repeat the process all while putting the level values

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0)
            return mat;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });

                } else if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    q.add(new int[] { nr, nc });
                }
            }

        }
        return mat;
    }
}