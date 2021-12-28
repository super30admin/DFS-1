//SC : o(mn)
//TC : o(mn)
public class Problem2 {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length==0){
            return mat;
        }
        Queue<Integer[]> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;

        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        int level=1;
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(mat[i][j]==1){
                    mat[i][j]=-1;
                }else if(mat[i][j]==0){
                    queue.add(new Integer[]{i,j});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int size= queue.size();
            for(int i=0; i<size;i++){
                Integer[] element = queue.poll();
                for(int[] dir : dirs){
                    int nr = dir[0]+element[0];
                    int nc = dir[1]+element[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1){
                        mat[nr][nc]=level;
                        queue.add(new Integer[]{nr,nc});
                    }
                }
            }
            level++;
        }
        
        return mat;
    }
}
