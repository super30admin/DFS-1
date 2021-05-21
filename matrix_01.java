import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class matrix_01 {

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
         int col = matrix[0].length;
         Queue<int[]> queue = new LinkedList<>();
         for (int i=0; i<row; i++) {
             for (int j=0; j<col; j++) {
                 if (matrix[i][j] == 0)
                     queue.add(new int []{i, j});
                 else
                     matrix[i][j] = Integer.MAX_VALUE; // to mark it as not visited
             }
         }
         int [][] directions = new int [][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
         while (!queue.isEmpty()) {
             int [] current = queue.poll();
             int x = current[0];
             int y = current[1];
             for (int [] dir : directions) {
                 int newX = dir[0] + x;
                 int newY = dir[1] + y;
                 if (newX < 0 || newY < 0 || newX >= row || newY >= col || matrix[newX][newY] <= matrix[x][y] + 1)
                     continue;
                 queue.add(new int [] {newX, newY});
                 matrix[newX][newY] = matrix[x][y] + 1;
             }
         }
         return matrix;
 }    
    
}
