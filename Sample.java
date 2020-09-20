// Problem 1 - 01 Matrix
// Time Complexity : O(n * m) where n = number of rows, m = number of cols
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Algorithm
// 1 - initiliaze directions arrays
// 2 - add position of element with 0 in queue
// 3 - convert element with 1 to positive infinity
// 4 - while condition
// 5 - get the front of the queue
// 6 - loop over directions
// 7 - calculate new row and col
// 8 - check for edge cases and if previous element + 1 is less than new element distance
// 9 - if true, then add it to queue
class Solution {
  public int[][] updateMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return matrix;
    }

    int n = matrix.length;
    int m = matrix[0].length;
    // 1
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    Queue<int[]> queue = new LinkedList<>();

    for (int i=0; i<n; i++) {
      for (int j=0; j<m; j++) {
        // 2
        if (matrix[i][j] == 0) {
          queue.add(new int[]{i, j});
        } else if (matrix[i][j] == 1) { // 3
          matrix[i][j] = Integer.MAX_VALUE;
        }
      }
    }
    // 4
    while (!queue.isEmpty()) {
      // 5
      int[] front = queue.poll();

      int i = front[0];
      int j = front[1];
      // 6
      for (int[] dir : dirs) {
        // 7
        int r = i + dir[0];
        int c = j + dir[1];
        // 8
        if (r >= 0 && r < n && c >= 0 && c < m && (matrix[i][j] + 1) < matrix[r][c]) {
          matrix[r][c] = matrix[i][j] + 1;
          // 9
          queue.add(new int[]{r, c});
        }
      }
    }

    return matrix;
  }
}

// Problem 2 - Flood Fill
// Time Complexity : O(n * m) where n = number of rows, m = number of cols
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Algorithm
// 1 - initiliaze directions array
// 2 - add the source element to queue
// 3 - while condition
// 4 - get the front of the queue
// 5 - if the current element equals oldColor, change it to new
// 6 - loop over directions
// 7 - get the new position
// 8 - check for valid index and if the element at new position equals oldColor, then change it to newColor and add it to queue
class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor) {
      return image;
    }
    // 1
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Queue<int[]> queue = new LinkedList<>();
    // 2
    queue.add(new int[]{sr, sc});
    int oldColor = image[sr][sc];
    // 3
    while (!queue.isEmpty()) {
      // 4
      int[] front = queue.poll();
      int i = front[0];
      int j = front[1];
      // 5
      if (image[i][j] == oldColor) {
        image[i][j] = newColor;
      }
      // 6
      for (int[] dir : dirs) {
        // 7
        int r = i + dir[0];
        int c = j + dir[1];
        // 8
        if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == oldColor) {
          image[r][c] = newColor;
          queue.add(new int[]{r, c});
        }
      }
    }

    return image;
  }
}
