// Time Complexity: O(m x n)
// Space Complexity: O(m x n)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return matrix;
        }

        Queue<int[]> q = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0]. length;
        for(int i = 0; i< n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                }  else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int[] dir: dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x >= 0 && x < n && y >= 0 && y < m && (matrix[x][y] > matrix[cur[0]][cur[1]] + 1)) {
                    q.add(new int[] {x, y});
                    matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
                }
            }
        }
        return matrix;
    }
}