class Matrix01{
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length; int n=mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                } else
                    mat[i][j] = -1;
            }
        }

        int dist = 1;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                for(int[] dir: dirs){
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if(nr >= 0 && nc >=0 && nr<m && nc<n && mat[nr][nc] == -1){
                        q.add(new int[]{nr,nc});
                        mat[nr][nc] = dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}