// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    //base case
    if (
      image == null ||
      image.length == 0 ||
      image[0] == null ||
      image[0].length == 0 ||
      image[sr][sc] == newColor
    ) return image;
    int m = image.length;
    int n = image[0].length;
    //we store the initial color of the starting point and add it to the queue
    int initial_color = image[sr][sc];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { sr, sc });

    //Direction array
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    while (!queue.isEmpty()) {
      int size = queue.size();
      //changing the starting point to a new color
      image[sr][sc] = newColor;
      for (int x = 0; x < size; x++) {
        int[] pair = queue.poll();
        for (int[] dir : dirs) {
          int i = pair[0] + dir[0];
          int j = pair[1] + dir[1];
          //if the current cell has the starting color, we change the color to a new color
          if (
            i >= 0 && i < m && j >= 0 && j < n && image[i][j] == initial_color
          ) {
            image[i][j] = newColor;
            queue.add(new int[] { i, j });
          }
        }
      }
    }
    return image;
  }
}
