/* Time Complexity : O(m*n)
 * Space Complexity : O(m*n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //null
        if(matrix == null || matrix.length == 0) return matrix;
        Queue<int []> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dirs = new int [][] {{0,1}, {0,-1}, {-1,0}, {1,0}};
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[] {i, j});
                } else {
                   matrix[i][j] = -1; 
                }
            }
        }
        int dist = 1; // dist = 0
        while(!q.isEmpty()){
            int size = q.size();
            //processing level
            for(int i = 0; i < size; i++){
                int [] curr = q.poll();
                for(int [] dir: dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    //check bounds
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1){
                        matrix[nr][nc] = dist; //dist + 1 - if dist = 0
                        q.add(new int [] {nr, nc});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}
