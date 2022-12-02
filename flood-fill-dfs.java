//tc is O(mxn)
//sc is O(mxn)

class Solution {
    int oldColor;
    int[][] dirs;
    int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        m = image.length;
        n = image[0].length;
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        oldColor = image[sr][sc];
        dfs(image, sr, sc, color);

        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int color) {

        // base
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != oldColor) {
            return;
        }

        // logic

        image[sr][sc] = color;

        for (int[] dir : dirs) {
            int row = sr + dir[0];
            int col = sc + dir[1];

            dfs(image, row, col, color);
        }

    }
}