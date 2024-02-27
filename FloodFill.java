// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[][] dirs;
    int m;
    int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //                       D         R         U          L
        dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        // helperBfs(image, sr, sc, color);
        helperDfs(image, sr, sc, color);
        return image;
    }

    private void helperDfs(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return;
        }

        int ogColor = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc, color, ogColor);
    }

    private void dfs(int[][] image, int r, int c, int targetColor, int ogColor) {
        // base
        if (r < 0 || c < 0 || r >= m || c >= n || (image[r][c] != ogColor)) {
            return;
        }

        // logic
        image[r][c] = targetColor;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(image, nr, nc, targetColor, ogColor);
        }
    }

    private void helperBfs(int[][] image, int r, int c, int targetColor) {
        m = image.length;
        n = image[0].length;
        if (image[r][c] == targetColor) {
            return;
        }

        int ogColor = image[r][c];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        image[r][c] = targetColor;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] arr = q.poll();
                for (int[] dir : dirs) {
                    int nr = arr[0] + dir[0];
                    int nc = arr[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == ogColor) {
                        q.add(new int[] { nr, nc });
                        image[nr][nc] = targetColor;
                    }
                }
            }
        }

    }
}