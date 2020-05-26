package s30Coding;
import java.util.*;

//Time Complexity  :- O(m*n) where m is the number of rows and n is number of columns
//Space Complexity :- O(m*n) where m is the number of rows and n is number of columns

//LeetCode :- Yes
//Logic :- BFS solution

public class ZeroOneMatrix {
	public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    matrix[r][c] != -1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
            }
        }
        
        return matrix;
    }
}
