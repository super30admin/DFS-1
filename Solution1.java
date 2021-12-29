class Solution {
    //BFS
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat[0].length==0)
            return mat;
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q= new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        int dirs[][]= new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for (int i=0;i<size;i++){
              int curr[]=q.poll();
            for(int[] dir:dirs){
                int nr=curr[0]+dir[0];
                int nc=curr[1]+dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc< n && mat[nr][nc]==1 && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    mat[nr][nc]=level;
                    q.add(new int[]{nr,nc});
                }
            }  
            }
            level++;
        }
        return mat;
    }
    
}