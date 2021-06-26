// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package dfs1;

import java.util.*;

public class FloodFillBFS {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        int color = image[sr][sc];
        int m = image.length, n = image[0].length;
        image[sr][sc] = newColor;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();

            for (int[] dir : dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color) {
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = newColor;
                }
            }
        }
        return image;
    }
}
