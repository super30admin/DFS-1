class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int l = mat.length;
        int w = mat[0].length;
        Queue<int []> q = new LinkedList<>();

        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        
        //set all 1's to -1
        for(int i=0;i<l;i++){
            for(int j=0;j<w;j++){
                if(mat[i][j]==1){
                    mat[i][j]= -1;
                }else{
                    q.add(new int[]{i,j});
                }
            }
        }

        int dist =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int [] curr = q.poll();
                for(int[] d:dir){
                    int nr = d[0] + curr[0];
                    int nc = d[1] + curr[1];
                    if(nr >=0 && nc >= 0 && nr < l && nc < w && mat[nr][nc]==-1){
                        mat[nr][nc] = dist+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            dist++;
        }

        return mat;
    }
}