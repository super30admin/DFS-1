import java.util.*;

// BFS:
public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        if(mat.length==0||mat==null) return mat;
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

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
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir:dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc] == -1){
                        mat[nr][nc] = dist;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
