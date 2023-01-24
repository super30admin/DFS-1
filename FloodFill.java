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
            for (int[] direction : directions) {
                int nr = direction[0] + cr;
                int nc = direction[1] + cc;
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
    int[][] directions;
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

    private void dfs(int[][] image, int sourceRow, int sourceCol, int newColor, int oldColor, int[][] directions, int m, int n) {
        if (sourceRow < 0 || sourceCol < 0 || sourceRow == m || sourceCol == n || image[sourceRow][sourceCol] != oldColor) {
            return;
        }
        image[sourceRow][sourceCol] = newColor;
        for (int[] direction : directions) {
            int dirRow = direction[0] + sourceRow;
            int dirCol = direction[1] + sourceCol;
            dfs(image, dirRow, dirCol, newColor, oldColor, directions, m, n);
        }
    }

}