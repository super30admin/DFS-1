// Time Complexity : O(m * n)  [iterating over each pixel]
// Space Complexity : O(m * n)  [size of call stack calling dfs]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Iterate over each item in the grid
// Perform dfs on this item
// In dfs if color is orignal color then change it to newColor
class FllodFillSolution {
    int newColorToApply;
    int orignalColor;
    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // null check
        if (image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;

        newColorToApply = newColor;
        orignalColor = image[sr][sc];

        m = image.length;
        n = image[0].length;

        dfs(image, sr, sc);

        return image;
    }

    private void dfs(int[][] image, int r, int c) {
        // base
        if (r < 0 || r == m || c < 0 || c == n || image[r][c] != orignalColor)
            return;

        // logic
        image[r][c] = newColorToApply;
        for (int[] dir : dirs) {
            dfs(image, r + dir[0], c + dir[1]);
        }
    }
}