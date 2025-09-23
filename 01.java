class Solution {
    int[][] dirs;
    int m,n;
    public int[][] updateMatrix(int[][] mat) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
       this.m=mat.length;
        this.n=mat[0].length;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j]*=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            for(int[] d:dirs){
                int nr=curr[0]+d[0];
                int nc=curr[1]+d[1];
                if(nr>=0&&nr<m&&nc>=0&&nc<n&&mat[nr][nc]==-1){
                    q.add(new int[]{nr,nc});
                    mat[nr][nc]=mat[curr[0]][curr[1]]+1;
                }
            }
        }
        return mat;
        
    }
}