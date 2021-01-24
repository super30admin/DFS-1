// Time Complexity : O(mn)
 	// Space Complexity : O(mn)
 	// Did this code successfully run on Leetcode : yes
 	// Any problem you faced while coding this : No
 	// Your code here along with comments explaining your approach
 	/*
 	 * This approach is by using BFS method.
 	 * Here, when traversing the matrix, we will start with the independent nodes (i.e., here it is 0) and add them inside the queue.
 	 * When the traversal comes across 1 then change their values to a not 1 (i.e., -1 or infinity).
 	 * Next, get all the nodes from the 4 directions which are -1 and add them in the queue for the next traversal and make their values equal to the distance value.
 	 */

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        Queue<int []> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int []{i,j});
                }
                else{
                    matrix[i][j] = -1;
                }
            }
        }
        
        int [][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
       // int dist = 1;
        while(!q.isEmpty()){
           // int size = q.size();
            //for(int i = 0; i < size; i++){
                int []  curr = q.poll();
                for(int [] dir : dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1){
                        matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                        q.add(new int []{r,c});
                    }
                }
           // }
           // dist++;
        }
        return matrix;
    }
}
