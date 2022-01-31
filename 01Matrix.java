class Solution {
    // Time Complexity : O(mn), where m is the no of rows and n is the no of columns
    // Space Complexity : O(mn)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using BFS
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()) {
            int[] cell = q.poll();

            for(int[] d : dirs) {
                int nr = cell[0] + d[0];
                int nc = cell[1] + d[1];
                //bounds check
                if(nr >= 0 && nr < r && nc >= 0 && nc < c && mat[nr][nc] == -1) {
                    mat[nr][nc] = mat[cell[0]][cell[1]]+1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return mat;
    }
}