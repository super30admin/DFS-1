class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    mat[i][j]=-1;
                }
                else{
                    q.offer(new int[] {i,j});
                }
            }
        }
        int [][] drs = {{1,0},{0,1},{-1,0},{0,-1}};
        int dist=1;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int [] curr = q.poll();
                
                for(int[] dr : drs){
                    int nr = curr[0]+dr[0];
                    int nc = curr[1]+dr[1];
                    
                    if(nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc]==-1){
                        q.add(new int[] {nr,nc});
                        mat[nr][nc] = dist;
                    }
                }
            }
            
            dist++;
            
        }
        
        return mat;
    }
}