package dfs1;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	//BFS
  	//Time Complexity : O(m*n), where m are the rows and n are the columns of the matrix
  	//Space Complexity : O(m*n), for queue
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
	public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)
            return mat;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0)
                    q.offer(new int[] {i, j});
                else
                    mat[i][j] = -1;
            }
        }
        
        int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if(r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == -1) {
                    q.offer(new int[] {r, c});
                    mat[r][c] = mat[curr[0]][curr[1]] + 1;
                }
            }
        }
        
        return mat;
    }
}
