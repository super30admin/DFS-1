import java.util.LinkedList;
import java.util.Queue;

// tc : O(MN) SC:O(MN)
// tried coding in java for change 
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            
            for (int[] d : dir) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                
                if (r < 0 || c < 0 || r >= m || c >= n || mat[r][c] <= mat[cell[0]][cell[1]] + 1 ) 
                    continue;
                
                queue.add(new int[]{r, c});
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }
        }
        
        return mat;
    }
}