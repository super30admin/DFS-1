// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)
            return mat;
        
        int m = mat.length, n = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        //find all 0s and add them to the queue and make rest -1
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0)
                    q.add(new int[]{i, j});
                else
                    mat[i][j] = -1;
            }
        }
        
        int dist = 1;
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    
                    //check if the cell is inbound
                    if(r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1){
                        mat[r][c] = dist;
                        q.add(new int[]{r, c});
                    }
                }
            }
            
            dist++;
        }
        
        return mat;
    }
}