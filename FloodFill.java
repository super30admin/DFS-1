// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach
//BFS solution
class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0 || image[sr][sc] == newColor)
      return image;

    Queue<Integer> q = new LinkedList<>();
    int m = image.length;
    int n = image[0].length;
    // Add the source row and column to queue
    q.add(sr);
    q.add(sc);
    // Store the source color
    int color = image[sr][sc];
    // Change the source to new color
    image[sr][sc] = newColor;
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    while (!q.isEmpty()) {
      // remove the row and column
      int cr = q.poll();
      int cc = q.poll();
      for (int[] dir : dirs) {
        // add row and column to the four direction
        int r = cr + dir[0];
        int c = cc + dir[1];
        // if the neighbour nodes have the original color
        // Change color and add thier position to queue to check their neighbours
        if (r >= 0 && r < m && c >= 0 && c < n && image[r][c] == color) {
          image[r][c] = newColor;
          q.add(r);
          q.add(c);
        }
      }
    }
    return image;
  }
}

// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here with comments explaining your approach
// DFS solution

class Solution {
  int m, n, color;

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0 || image[sr][sc] == newColor)
      return image;

    m = image.length;
    n = image[0].length;

    // Store the source color
    color = image[sr][sc];
    helper(image, sr, sc, newColor);
    return image;

  }

  private void helper(int[][] image, int sr, int sc, int newColor) {
    if (sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] != color)
      return;

    image[sr][sc] = newColor;
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    for (int[] dir : dirs) {
      // add row and column to the four direction
      int r = sr + dir[0];
      int c = sc + dir[1];
      // Call the method with new row and column
      helper(image, r, c, newColor);
    }
  }
}
