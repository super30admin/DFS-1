// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        //null
        if(matrix == null || matrix.length == 0) return matrix;

        int m = matrix.length, n = matrix[0].length;
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,-1}, {0,1}};

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i< m ; i++){
            for(int j = 0; j< n ; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }

        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i= 0; i< size; i++){
                int[] curr = q.poll();

                for(int[] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if(nr >= 0 && nc >= 0 &&
                            nr < m  && nc < n && matrix[nr][nc] == -1){
                        q.add(new int[]{nr,nc});
                        matrix[nr][nc] = dist;
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}
