class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    mat[i][j] =-1;
                }
                else{
                    q.add(new int[]{i,j});
                }
            }
        }

        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();

                for(int [] dir : dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    if(nr<n && nc<m && nc>=0 && nr>=0 && mat[nr][nc]==-1){
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