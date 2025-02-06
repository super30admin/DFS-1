//TC: O(n)
//SC: O(n)
//approach: bfs

import java.util.LinkedList;
import java.util.Queue;

public class NearestZeroInMatrix {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = Integer.MAX_VALUE;
                }else{
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];
                if(newRow>=0 && newRow<mat.length && newCol>=0 && newCol<mat[0].length && mat[newRow][newCol] > mat[curr[0]][curr[1]]+1){
                    mat[newRow][newCol] = mat[curr[0]][curr[1]]+1;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
}
