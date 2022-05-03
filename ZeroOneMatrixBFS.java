// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixBFS {
    public int[][] updateMatrix(int[][] mat) {

        //bfs
        if(mat == null || mat.length == 0){
            return mat;
        }

        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        // Matrix and queue ready

        int level = 1;

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] startingPosition = queue.poll();

                for(int[] dir:dirs){

                    int newRow = startingPosition[0] + dir[0];
                    int newCol = startingPosition[1] + dir[1];

                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && mat[newRow][newCol] == -1){
                        mat[newRow][newCol] = level;
                        queue.add(new int[]{newRow, newCol});

                    }
                }
            }
            level++;

        }

        return mat;
    }
}
