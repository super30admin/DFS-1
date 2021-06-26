// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package dfs1;

import java.util.*;

public class FloodFillDFS {

    int color, m, n;
    int dirs[][];

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        color = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor) {
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color) {
            return;
        }
        image[sr][sc] = newColor;
        for (int[] dir : dirs) {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            dfs(image, nr, nc, newColor);
        }

    }
}
