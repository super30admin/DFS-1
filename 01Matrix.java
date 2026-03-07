// TimeComplexity: O(M*N)
// SpaceComplexity: O(M*N)
// Ran on Leetcode successfully: yes
class Solution {
    int[][] dirs;
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // lazy load directions
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        Queue<int[]> q = new LinkedList<>();
        // initialize all 1 to -1 and add index to queue for 0's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }

            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                // for each direction, check unvisited neighbours, increament and set neighbor
                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1) {
                    mat[r][c] = mat[curr[0]][curr[1]] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }

        return mat;
    }
}