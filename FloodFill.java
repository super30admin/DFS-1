public class FloodFill {
    // TC: O(M * N) where M is number of rows and N is number of cols;
    // SC: O(1)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor || image[i][j] == newColor) {
            return;
        }
        image[i][j] = newColor;
        dfs(image, i, j + 1, oldColor, newColor);
        dfs(image, i, j - 1, oldColor, newColor);
        dfs(image, i + 1, j, oldColor, newColor);
        dfs(image, i - 1, j, oldColor, newColor);
    }
}
