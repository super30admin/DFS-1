// Time Complexity : O(m*n) where m and n are the dimensions of the grid
// Space Complexity : O(m*n) where m and n are the dimensions of the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS using queue

class zeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[] {i,j});
                }
            }
        }
        int[][] dirs = {{1,0},{0,1}, {-1,0}, {0,-1}};
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && matrix[row][col] == 1) {
                        matrix[row][col] = -dist;
                        q.add(new int[] {row, col});
                    }
                }       
            }
            dist++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] *= -1;
            }
        }
        return matrix;
    }
}