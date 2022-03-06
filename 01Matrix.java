// TC: O(n)
// SC: O(n)

// Approach: Use a queue to iterate over the matrix and add the i, j
// values of elements which are 0. We update other values to -1.
// Then for every value in queue, we check their neighbours. If the
// neighbour is -1, we add it to queue and update the value in the matrix.

// LC- 542. 01 Matrix


public class 01Matrix {
  int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
  
  public int[][] updateMatrix(int[][] mat) {
      int m = mat.length;
      int n = mat[0].length;
      
      Queue<int[]> queue = new LinkedList<>();
      for(int i = 0; i < m; i++) {
          for(int j = 0; j < n; j++) {
              if(mat[i][j] == 0) {
                  queue.offer(new int[] {i, j});
              } else {
                  mat[i][j] = -1;
              }
          }
      }
      
      while(!queue.isEmpty()) {
          int[] cell = queue.remove();
          
          for(int[] d: directions) {
              int r = cell[0] + d[0];
              int c = cell[1] + d[1];
              
              if(r < 0 || r > m-1 || c < 0 || c > n-1 || mat[r][c] != -1) {
                  continue;
              }
              queue.add(new int[] {r, c});
              
              mat[r][c] = mat[cell[0]][cell[1]] + 1;
          }
      }
      
      return mat;
  }
}