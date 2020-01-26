// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

public class NearestZero {
	class Solution {
	    public int[][] updateMatrix(int[][] matrix) {
	        if(matrix == null || matrix.length == 0) return matrix;
	        int m = matrix.length;
	        int n = matrix[0].length;
	        Queue<int[]> q = new LinkedList<>();
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(matrix[i][j] == 0) q.add(new int[]{i, j});
	            }
	        }
	        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	        int dist = 1;
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int i = 0; i < size; i++){
	                int[] curr = q.poll();
	                for(int[] dir: dirs){
	                    int r = curr[0] + dir[0];
	                    int c = curr[1] + dir[1];
	                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == 1){
	                        matrix[r][c] = -dist;
	                        q.add(new int[]{r, c});
	                    }
	                }
	            }
	            dist++;
	        }
	        
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                matrix[i][j] = -1 * matrix[i][j];
	            }
	        }
	        return matrix;
	    }
	}
}
