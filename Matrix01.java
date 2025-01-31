class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length ==0){
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int level =0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            // int size = q.size();
            //for(int i=0; i<size; i++) {
            int[] curr = q.poll();
            for(int[] rec: dirs){
                int nr = rec[0] + curr[0];
                int nc = rec[1] + curr[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(mat[nr][nc] == -1){
                        q.add(new int[]{nr,nc});
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    }
                }
            }
            //}
            // level++;
        }

        return mat;
    }
}
