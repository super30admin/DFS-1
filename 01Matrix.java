// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public int[][] updateMatrix(int[][] mat) {
    if(mat == null || mat.length == 0) return mat;
    int m = mat.length;
    int n = mat[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};

    // Add all the 0s to the queue and change 1 to -1.
    for(int i = 0; i<m; i++) {
      for(int j = 0; j<n; j++) {
        if(mat[i][j] == 0) queue.add(new int[]{i,j});
        else mat[i][j] = -1;
      }
    }

    // If -1, change it to neighbour + 1.
    while(!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      for(int[] dir: dirs) {
        int newX = x + dir[0];
        int newY = y + dir[1];
        if(newX>=0 && newX<m && newY>=0 && newY<n && mat[newX][newY] == -1 ) {
          mat[newX][newY] = mat[x][y] + 1;
          queue.add(new int[]{newX, newY});
        }
      }
    }
    return mat;
  }
}