/**** Method 1 ****/
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)

//Successfully submitted in LeetCode

//We use Depth First Search, and start with the given index and then move all the directions and change the current node to new color before traversing. Then base condition is if the value at the index is not old color or equals to new color.

/**** Method 2 ****/
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)

//Successfully submitted in LeetCode

//We use Breath first search and store the given index in Queue, and loop while queue is not empty, remove the index and change it color to new color and traverse all its directions put the index which has old color as value into queue and continue with the while loop.

import java.util.LinkedList;
import java.util.Queue;

public class _733_Flood_Fill {

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int neig[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    int oldColor = image[sr][sc];

    dfs(sr, sc, image.length, image[0].length, image, oldColor, color, neig);
    bfs(sc, sc, sc, sc, image, oldColor, oldColor, neig);

    return image;
  }

  /**** Method 1 ****/
  private void dfs(
    int i,
    int j,
    int n,
    int m,
    int[][] image,
    int oldColor,
    int newColor,
    int neig[][]
  ) {
    if (image[i][j] != oldColor || image[i][j] == newColor) {
      return;
    }

    image[i][j] = newColor;

    for (int arr[] : neig) {
      int nr = i + arr[0];
      int nc = j + arr[1];
      if ((nr >= 0 && nr < n) && (nc >= 0 && nc < m)) {
        dfs(nr, nc, n, m, image, oldColor, newColor, neig);
      }
    }
  }

  /**** Method 2 ****/
  private void bfs(
    int i,
    int j,
    int n,
    int m,
    int[][] image,
    int oldColor,
    int newColor,
    int[][] neig
  ) {
    if (oldColor == newColor) return;

    Queue<int[]> que = new LinkedList<>();
    que.add(new int[] { i, j });

    while (!que.isEmpty()) {
      int[] polled = que.poll();
      int x = polled[0];
      int y = polled[1];

      image[x][y] = newColor;

      for (int[] dir : neig) {
        int nx = x + dir[0];
        int ny = y + dir[1];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (image[nx][ny] == oldColor) {
            que.add(new int[] { nx, ny });
          }
        }
      }
    }
  }
}
