package dfs1;

import java.util.LinkedList;
import java.util.Queue;

/*
Idea :  1. We do recursive depth first search in all directions for distance of nearest 0.
 		2. We are going to maintain a dp array in which we are going to store already 
 			calculated distances which can be reused to calculate new distances inclusive of previous paths.

Time Complexity : O(r*c) because in worst case, we might process whole matrix.
Space Complexity : O(r*c).

Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

public class _01Matrix {

	public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length ;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = dfs(matrix, dp, i, j);
            }
        }
       return dp;     
    }
	
	public static int dfs(int[][] matrix,int[][] dp, int i, int j){
        int m = matrix.length ;
        int n = matrix[0].length;
        // Base Case 
         if(i<0 || i>m-1 || j < 0 || j > n-1) return 9999;
         if(matrix[i][j] == 0) return 0;
         // Case 1 Find 0 on top
         if(i > 0 && matrix[i-1][j] == 0) return 1;
         // Case 2 Find 0 on right
         if(j < n-1 && matrix[i][j+1] == 0) return 1;
         // Case 3 Find 0 on bottom
         if(i < m-1 && matrix[i+1][j] == 0) return 1;
         // Case 4 Find 0 on left
          if(j>0 && matrix[i][j-1] == 0) return 1;
        // Case when no zero around ..do DFS
        int left,bottom,right,top;
        left=top=9999;
        // if recursive call
        if(i > 0 && dp[i-1][j] != 0){
            top = dp[i-1][j];
        }
        if(j> 0 && dp[i][j-1] != 0){
            left = dp[i][j-1];
        }
        bottom = dfs(matrix, dp,i+1, j);
        right = dfs(matrix, dp,i,j+1);
        return Math.min(Math.min(left, right), Math.min(top,bottom))+1; 
    }
	
	
	
	
	
	
	
	
	
/*	
 * 
 * 
 * Idea :  1. We go through the entire matrix and put the coordinates of 0 in queue and replace 1's by max values.
 		2. Replace them with the new color value and keep on repeating these two steps for 
 		   subsequent neighbors of previous 4-directional neighbors.

Time Complexity : O(r*c) because in worst case, we might process whole matrix.
Space Complexity : O(r*c).

Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
	
	public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        
        return matrix;
    }
*/	
}

