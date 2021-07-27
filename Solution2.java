// Time complexity: O(m*n), where m*n is the size of mat.
// Space complexity: O(m*n)

import java.util.*;

class Solution2 {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat; 
        
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>(); 
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if (mat[r][c] == 0) {
                    // offer 0's 
                    queue.offer(new int[]{r,c});
                }
            }
        }

        int directions[][] = {{-1,0},{0,-1},{1,0},{0,1}}; 
        int[][] output = new int[m][n];
        // initialize level to 1
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int r = cell[0] + directions[d][0];
                    int c = cell[1] + directions[d][1];
                    if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] != 0) {
                        // set the level
                        output[r][c] = level;
                        mat[r][c] = 0;
                        // add in the queue
                        queue.offer(new int[] { r, c });
                    }
                }
            }
            // increment level
            level++;
        }
        
        return output;
    }

}