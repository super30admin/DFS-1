// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {

  public int[][] updateMatrix(int[][] mat) {
    //Base case
    if (mat == null || mat.length == 0 || mat[0].length == 0) return mat;
    int m = mat.length, n = mat[0].length;
    Queue<int[]> q = new LinkedList<>();
    //Initialisation
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        //adding all the possible starting points to the queue
        if (mat[i][j] == 0) q.add(new int[] { i, j });
        //Encoding 1's to infinity
        else mat[i][j] = Integer.MAX_VALUE;
      }
    }
    //Directions of travel
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    //BFS Traversal
    while (!q.isEmpty()) {
      int[] front = q.poll();
      for (int[] dir : dirs) {
        int i = front[0] + dir[0];
        int j = front[1] + dir[1];
        if (
          i >= 0 &&
          i < m &&
          j >= 0 &&
          j < n &&
          (mat[front[0]][front[1]] + 1 < mat[i][j])
        ) {
          q.add(new int[] { i, j });
          mat[i][j] = mat[front[0]][front[1]] + 1;
        }
      }
    }
    return mat;
  }
}
//TC - O(M * N)
//SC - O(M * N)
