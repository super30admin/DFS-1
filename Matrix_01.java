/**
 * Solution 1
 * 
 * LeetCode Execution: No Problem
 * 
 * Time Complexity: O(r*c)
 * Space Complexity: O(r*c) For Queue
 * 
 * Approach: BFS (Start from every zero and update the value when one is found)
 * 
 */


class Solution {
  int[] dr = {1, 0, -1, 0};
  int[] dc = {0, 1, 0, -1};
  
  public int[][] updateMatrix(int[][] matrix) {
      
      Queue<Node> q = new LinkedList<>();
      
      for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[0].length; j++) {
              if (matrix[i][j] == 0) {
                  q.add(new Node(0, i, j));
              } else {
                  matrix[i][j] = -1;
              }
          }
      }
      
      helper(matrix, q);
      
      return matrix;
  }
  
  public void helper(int[][] matrix, Queue<Node> q) {
      
      while (!q.isEmpty()) {
          
          Node tmp = q.remove();
          
          for (int k = 0; k < 4; k++) {
              int nr = dr[k] + tmp.r;
              int nc = dc[k] + tmp.c;
              
              if (0 <= nr && nr < matrix.length && 0 <= nc && nc < matrix[0].length) {
                  
                  if (matrix[nr][nc] == -1 || matrix[nr][nc] > tmp.depth + 1) {
                      
                      matrix[nr][nc] = tmp.depth + 1;
                      q.add(new Node(tmp.depth + 1, nr, nc));
                  } 
              }
          }
          
      }
  }
  
  class Node {
      int depth;
      int r;
      int c;
      
      Node (int depth, int r, int c) {
          this.depth = depth;
          this.r = r;
          this.c = c;
      }
  }
}