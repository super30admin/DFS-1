/**** Method 1 ****/
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)

//Successfully submitted in LeetCode

//Using BFS to solve this problem, we can add all the zeros to queue(0's are independent), and change all the 1 to -1 to maintain as visited, we also maintain level, and each while loop we increment level, now we remove the index from queue check all it's direction values,if they are -1 we update them with level, and add the index value to queue and continue.

/**** Method 2 ****/
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)

//Successfully submitted in LeetCode

//Same as above, but we can also solve it without using level, we just update the value of all direction index with current index plus one.

/**** Method 3 ****/
//Time Complexity: O(m^2 * n^2)
//Space Complexity: O(m * n)

//Successfully submitted in LeetCode

//All 1s are initially marked as -1 to flag them as unprocessed cells. We run a DFS from every 0, assigning increasing distance values to reachable cells. The DFS only updates a cell if it's unvisited or if the new path offers a smaller distance..

import java.util.LinkedList;
import java.util.Queue;

public class _542_01_Matrix {

  /**** Method 1 ****/
  public int[][] updateMatrix(int[][] mat) {
    int neig[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    int n = mat.length;
    int m = mat[0].length;
    Queue<int[]> que = new LinkedList<>();

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 0) {
          que.add(new int[] { i, j });
        } else {
          mat[i][j] *= -1;
        }
      }
    }
    int level = 0;
    while (!que.isEmpty()) {
      int size = que.size();
      level++;
      for (int i = 0; i < size; i++) {
        int polled[] = que.poll();
        for (int dir[] : neig) {
          int nr = polled[0] + dir[0];
          int nc = polled[1] + dir[1];

          if (
            (nr >= 0 && nr < n) && (nc >= 0 && nc < m) && (mat[nr][nc] == -1)
          ) {
            mat[nr][nc] = level;
            que.add(new int[] { nr, nc });
          }
        }
      }
    }
    return mat;
  }

  /**** Method 2 ****/
  public int[][] updateMatrix1(int[][] mat) {
    int neig[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    int n = mat.length;
    int m = mat[0].length;
    Queue<int[]> que = new LinkedList<>();

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 0) {
          que.add(new int[] { i, j });
        } else {
          mat[i][j] *= -1;
        }
      }
    }
    while (!que.isEmpty()) {
      int size = que.size();
      for (int i = 0; i < size; i++) {
        int polled[] = que.poll();
        for (int dir[] : neig) {
          int nr = polled[0] + dir[0];
          int nc = polled[1] + dir[1];

          if (
            (nr >= 0 && nr < n) && (nc >= 0 && nc < m) && (mat[nr][nc] == -1)
          ) {
            mat[nr][nc] = mat[polled[0]][polled[1]] + 1;
            que.add(new int[] { nr, nc });
          }
        }
      }
    }
    return mat;
  }

  /**** Method 3 ****/
  int[][] dirs;
  int m, n;

  public int[][] updateMatrix2(int[][] mat) {
    this.dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    this.m = mat.length;
    this.n = mat[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 1) mat[i][j] = -1;
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          dfs(mat, i, j, 1);
        }
      }
    }

    return mat;
  }

  private void dfs(int[][] grid, int i, int j, int dist) {
    for (int[] dir : dirs) {
      int r = dir[0] + i;
      int c = dir[1] + j;

      if (
        r >= 0 &&
        c >= 0 &&
        r < m &&
        c < n &&
        (grid[r][c] == -1 || grid[r][c] > dist)
      ) {
        grid[r][c] = dist;
        dfs(grid, r, c, dist + 1);
      }
    }
  }
}
