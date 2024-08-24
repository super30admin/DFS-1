// Problem 542. 01 Matrix
// Time Complexity : O(m*n)
// Space Complexity : O(m*h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] == -1) {
                        q.add(new int[]{nr, nc});
                        matrix[nr][nc] = dist + 1;
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}
