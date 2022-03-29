import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * time complexity O(m*n)
 * space complexity is O(m*n)
 * implemented using BFS
 * this could further be optimized to implement in place.
 */
class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Set<Integer> seen = new HashSet<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {0,1}, {1,0}};
        int[][] result = new int[rows][cols];
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                result[row][col] = Integer.MAX_VALUE;
            }
        }
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {

                if(grid[row][col] == 0) {
                    int pt = row*cols + col;
                    queue.add(pt);
                    seen.add(pt);
                }
            }
        }
        int dist = -1;
        while(!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int currPt = queue.remove();
                
                int i = currPt/cols;
                int j = currPt%cols;
                result[i][j] = Math.min(result[i][j], dist);            
                for(int[] dir : dirs) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if(ii >= 0 && ii < rows && jj >= 0 && jj < cols && !seen.contains(ii*cols + jj)) {
                        seen.add(ii*cols + jj);
                        queue.add(ii*cols + jj);
                    }
                }
            }
        }
        

        return result;
    }
}        
