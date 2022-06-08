class Solution {
    /**
     * DFS - traverse all direction, if colour is given colout change all its instances to new color.
     */
    int[][] dirs;
    int color;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor) {
        // base
        if (sr < 0 || sc < 0 || sr == image.length
                || sc == image[0].length || image[sr][sc] != color) {
            return;
        }

        //logic
        image[sr][sc] = newColor;
        for (int[] dir : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c, newColor);
        }
    }
}
