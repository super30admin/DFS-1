//Time Comlexity=O(mn)
//Space Complexity=O(mn)
public class UpdateMatrixBFS {

    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0) return matrix;

        int m=matrix.length,n=matrix[0].length;

        Queue<int[]> q=new LinkedList();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0) q.add(new int[]{i,j});
                else if(matrix[i][j]==1){
                    matrix[i][j]=-1;
                }
            }
        }
        int distance=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                for(int[] dis:dir){
                    int nr=curr[0]+dis[0];
                    int nc=curr[1]+dis[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && matrix[nr][nc]==-1){
                        matrix[nr][nc]=distance+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            distance++;
        }

        return matrix;
    }
}
