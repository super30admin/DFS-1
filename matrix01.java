// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : i Have learnt how to pick the initial elements while doing BFS.

// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0)
            return matrix;
        
        int m = matrix.length, n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1)
                    matrix[i][j] = -1;
                else{
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        int dist = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty()) {            
            int size = queue.size();            
            while(size-- > 0) {
                int[] curr = queue.poll();
                for(int i = 0; i < dirs.length; i++) {
                    int r = curr[0] + dirs[i][0];
                    int c = curr[1] + dirs[i][1];
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1){
                        queue.add(new int[]{r, c});
                        matrix[r][c] = dist + 1;
                    }
                }
            }
            dist++;
         }
        
        return matrix;        
    }
}