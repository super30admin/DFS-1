// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;
public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] != 0){
                    matrix[i][j] = Integer.MAX_VALUE;
                } else {
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                if(r>=0 && r < m && c>=0 && c < n){
                    if(matrix[r][c] > matrix[curr[0]][curr[1]] + 1){
                        matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                        q.offer(new int[]{r,c});
                    }
                }
            }
        }

        return matrix;
    }
}
