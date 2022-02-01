// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

public class FloodFill {
    private void dfs(int[][] image, int i, int j, int col, int nc) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != col)
            return;

        image[i][j] = nc;

        dfs(image, i+1, j, col, nc);
        dfs(image, i-1, j, col, nc);
        dfs(image, i, j+1, col, nc);
        dfs(image, i, j-1, col, nc);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
}
