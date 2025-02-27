// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int original = image[sr][sc];

        if (original == color)
            return image;

        dfs(image, sr, sc, color, m, n, original);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int m, int n, int oldColor) {

        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != oldColor)
            return;

        image[sr][sc] = newColor;
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];

            dfs(image, nr, nc, newColor, m, n, oldColor);
        }
    }
}
