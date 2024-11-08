class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n ; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                    result[i][j] = 0;
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int [] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if(result[nr][nc] > result[row][col] + 1) {
                        result[nr][nc] = result[row][col] + 1;
                        q.add(new int[]{nr,nc});
                    } 
                }
            }
        }
        return result;
    }
}