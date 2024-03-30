import java.util.LinkedList;
import java.util.Queue;
//tc = o(m*n)
//sc = o(m*n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue <int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 1; // this should not be inside queue, if it is it will reset to 0 always then
        while(!q.isEmpty()){
           
            int size = q.size();

            for(int i = 0; i< size;i++){
                int[] current = q.remove();
                for(int[] dir : dirs){
                    int nr = current[0] + dir[0];
                    int nc = current[1] + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1){
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