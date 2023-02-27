class Solution {
    public int[][] updateMatrix(int[][] mat) {
       if(mat==null) return new int[][]{};
        int m= mat.length;
        int n= mat[0].length;
        Queue <int[]> q= new LinkedList<>();
        int time=0;
        int count=0;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                } if(mat[i][j]==1) mat[i][j]=-1;}}
            if(q.size()==0) return mat;
            while(!q.isEmpty()){
                int[] curr= q.poll();
                for (int[]dir:dirs){
                    int nr= curr[0]+dir[0];
                     int nc= curr[1]+dir[1];
                     if(nr>=0 && nc >=0 && nr < m&& nc < n && mat[nr][nc]==-1){
                         mat[nr][nc]=mat[curr[0]][curr[1]]+1;
                         q.add(new int[]{nr,nc});
                }
                }
            }
            return mat;
    }
}