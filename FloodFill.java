// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FloodFillBFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0) {
            return image;
        }

        int m = image.length, n = image[0].length;
        int[][] directions = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int oldColor = image[sr][sc];
        if (image[sr][sc] == color) {
            return image;
        }

        Queue<Integer> bfsQueue = new LinkedList<>();
        image[sr][sc] = color;
        bfsQueue.add(sr);
        bfsQueue.add(sc);

        while (!bfsQueue.isEmpty()) {
            int cr = bfsQueue.poll();
            int cc = bfsQueue.poll();
            for (int[] dir : directions) {
                int nr = dir[0] + cr;
                int nc = dir[1] + cc;
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    bfsQueue.add(nr);
                    bfsQueue.add(nc);
                }
            }
        }
        return image;
    }
}

// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FloodFillDFS {
    int[][] dirs;
    int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        if (image == null || image.length == 0) {
            return image;
        }
        int[][] dirs = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        if (image[sr][sc] == color) {
            return image;
        }
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, color, oldColor, dirs, m, n);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor, int[][] dirs, int m, int n) {
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        for (int[] dir : dirs) {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            dfs(image, nr, nc, newColor, oldColor, dirs, m, n);
        }
    }

}