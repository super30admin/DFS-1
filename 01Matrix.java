// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * In this Solution, I have applied BFS approach. (In-place Modification of the same 2-D Array)
 * Enqueue the Os in the the queue. For all the 1s that are neighbors of the 0s in the queue, distance is the current distance
 * Increment distance and repeat the same process.
 */

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        
        int dist = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                
                for(int[] dir: dirs) {
                    int cur_row = cur[0] + dir[0];
                    int cur_col = cur[1] + dir[1];
                    
                    if(cur_row >= 0 && cur_col >= 0 && cur_row < rows && cur_col < cols && mat[cur_row][cur_col] == -1) {
                        mat[cur_row][cur_col] = dist;
                        q.add(new int[]{cur_row, cur_col});
                    }
                }
            }
            
            dist++;
        }
        
        return mat;
    }
}