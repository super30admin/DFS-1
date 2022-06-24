
// BFS approch
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//DFS approch

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {

    // BFS approch
    public static int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        // null case and edge case
        if (m == 0 || image[sr][sc] == newColor)
            return image;
        int n = image[0].length;
        // direction array
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();
        // add index of where we want to start;
        q.add(sr);
        q.add(sc);

        // original color
        int color = image[sr][sc];
        // change it to newColor
        image[sr][sc] = newColor;
        // BFS traversal
        while (!q.isEmpty()) {
            // current row and column
            int cr = q.poll();
            int cc = q.poll();

            // check in all the directions
            for (int[] dir : dirs) {
                // neighbour row
                int nr = cr + dir[0];
                // neighbour column
                int nc = cc + dir[1];
                // check bounds and our condition
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color) {
                    // add neighbouring index into the queue.
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = newColor;
                }
            }

        }
        return image;

    }

    private static int[][] dirs;

    // DFS approch
    public static int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        // null case and edge case
        if (m == 0 || image[sr][sc] == newColor)
            return image;
        int n = image[0].length;
        // direction array
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        // dfs
        dfs(image, sr, sc, m, n, newColor, image[sr][sc]);

        return image;

    }

    private static void dfs(int[][] image, int sr, int sc, int m, int n, int newColor, int color) {

        // base case
        if (sr < 0 || sc < 0 || sr > m - 1 || sc > n - 1 || image[sr][sc] != color)
            return;
        // logic
        image[sr][sc] = newColor;
        for (int[] dir : dirs) {
            dfs(image, sr + dir[0], sc + dir[1], m, n, newColor, color);
        }
    }

    public static void main(String[] args) {
        int[][] image = new int[][] {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] result = floodFill1(image, sr, sc, newColor);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println("=============");

        image = new int[][] {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        result = floodFill2(image, sr, sc, newColor);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }

}