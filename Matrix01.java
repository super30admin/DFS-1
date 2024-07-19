// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Matrix01 {
    // Using BFS
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null) return mat;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i =0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()) {
            // base
            // logic
            int[] currentElement = q.poll();
            for(int[] dir : dirs) {
                int r = currentElement[0];
                int c = currentElement[1];
                int nr = r + dir[0];
                int nc = c + dir[1];

                // checking boundaries
                if(nr >= 0 && nc >=0 && nr < m && nc < n && mat[nr][nc] == -1) {
                    mat[nr][nc] = mat[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return mat;
    }
}