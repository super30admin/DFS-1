// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


// BFS
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1)
                    matrix[i][j] = -1;
                else
                    q.add(new int[] {i, j});
            }
        }
        int dist = 1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                for(int[] dir : dirs) {
                    int r = dir[0] + point[0];
                    int c = dir[1] + point[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1) {
                        matrix[r][c] = dist;
                        q.add(new int[] {r, c});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}