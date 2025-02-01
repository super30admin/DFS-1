import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O(m*n)
// Space Complexity: O(m*n)
// Approach: BFS

public class Matrix01 {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            if(mat == null || mat.length == 0){
                return mat;
            }

            int lvl =0;
            int m = mat.length;
            int n = mat[0].length;
            int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
            Queue<int[]> q = new LinkedList<>();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j] == 0){
                        q.add(new int[]{i,j});
                    }else{
                        mat[i][j] = -1;
                    }
                }
            }
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    int[] val = q.poll();
                    for(int[] d : dirs){
                        int nr = val[0]+d[0];
                        int nc = val[1]+d[1];

                        if(nr >=0 && nr < m && nc >=0 && nc < n && mat[nr][nc] == -1){
                            mat[nr][nc] = 1+lvl;
                            q.add(new int[] {nr,nc});
                        }
                    }

                }
                lvl++;
            }
            return mat;

        }
    }
}
