// Time Complexity :O(mxn) where m == image.length and n==image[i].length
// Space Complexity :O(mxn) where m == image.length and n==image[i].length
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class FloodFillDFS {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int[][] res;

    class Pos {
        int x = -1, y = -1;

        Pos(int nx, int ny) {
            this.x = nx;
            this.y = ny;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0)
            return null;

        int rows = image.length;
        int cols = image[0].length;
        res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = image[i][j];
            }
        }
        dfs(image, sr, sc, newColor, rows, cols, sr, sc);
        return res;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int rows, int cols, int r, int c) {
        if (r < 0 || r == rows || c < 0 || c == cols || res[r][c] != image[sr][sc] || res[r][c] == newColor) {
            return;
        }

        res[r][c] = newColor;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(image, sr, sc, newColor, rows, cols, nr, nc);
        }
    }
}
