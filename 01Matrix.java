// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here with comments explaining your approach

class Solution {
  public int[][] updateMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0)
      return matrix;

    Queue<int[]> q = new LinkedList<>();
    int m = matrix.length;
    int n = matrix[0].length;
    int count = 0;
    // Count the number of 1's and add all 0's position to the queue
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0)
          q.add(new int[] { i, j });
        else {
          // Negate all values of 1 to -1;
          count++;
          matrix[i][j] = -1;
        }
      }
    }
    // If no 1's are present return
    if (count == 0)
      return matrix;
    // Initial level/distance will be 1
    int lvl = 1;
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] curr = q.poll();
        // check if neighbouring nodes of 0's have 1
        // if present change it to the level
        for (int[] dir : dirs) {
          int r = curr[0] + dir[0];
          int c = curr[1] + dir[1];
          if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1) {
            matrix[r][c] = lvl;
            q.add(new int[] { r, c });
          }
        }
      }
      // Increase the level
      lvl++;
    }
    return matrix;
  }
}