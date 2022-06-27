public class UpdateMatrixTLE {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0) return matrix;

        int m=matrix.length,n=matrix[0].length;
        boolean[][] visited;
        Queue<int[]> q=new LinkedList();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    q=new LinkedList();
                    q.add(new int[]{i,j});
                    visited=new boolean[m][n];
                    visited[i][j]=true;
                    boolean flag=false;
                    int distance=0;
                    while(!q.isEmpty() && !flag){
                        int size=q.size();
                        for(int k=0;k<size;k++){
                            int[] curr=q.poll();
                            for(int[] dis:dir){
                                int nr=curr[0]+dis[0];
                                int nc=curr[1]+dis[1];
                                if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc]){

                                    if(matrix[nr][nc]==0){
                                        flag=true;
                                        break;
                                    }else{
                                        q.add(new int[]{nr,nc});
                                        visited[nr][nc]=true;
                                    }
                                }
                                if(flag) break;
                            }
                            if(flag) break;
                        }
                        distance++;
                    }
                    matrix[i][j]=distance;
                }
            }
        }
        return matrix;
    }
}
