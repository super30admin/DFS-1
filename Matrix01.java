package DFS1;
// Time Complexity : O(mxn) + O(max(m , n)  = O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<mat.length; i++){
            for(int j=0;j<mat[0].length; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = -1;
                } else {
                    q.add(new int[]{i, j});
                }

            }
        }
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[] dir : dirs){
                int row = dir[0] + cell[0];
                int col = dir[1] + cell[1];
                if(row >=0 && row < mat.length && col >=0 && col < mat[0].length && mat[row][col] == -1){
                    mat[row][col] = mat[cell[0]][cell[1]] + 1;
                    q.add(new int[]{row, col});
                }
            }
        }
        return mat;
    }
}
