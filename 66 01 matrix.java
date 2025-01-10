// Time Complexity : O(m*n)
// Space Complexity :0(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    //aesha
    int m, n;
    int[][] dirs;

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int[][] result = new int[m][n];
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Initialize queue and set distances for '0' cells to 0
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    result[i][j] = 0; // Distance for '0' cells
                } else {
                    result[i][j] = Integer.MAX_VALUE; // Unprocessed '1' cells
                }
            }
        }

        // BFS to update distances
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                
                if (r >= 0 && c >= 0 && r < m && c < n && result[r][c] > result[row][col] + 1) {
                    result[r][c] = result[row][col] + 1;
                    q.add(new int[]{r, c}); // Add to queue for further processing
                }
            }
        }

        return result;
    }
}
