// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Using the directions matrix we recursively reach to all the neighbors and then check if the number is equal to the original color value.
class Solution {
    private int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int c = image[sr][sc];
        dfs(image, sr, sc, c, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int c, int color) {
        // base
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != c)
            return;
        if (image[sr][sc] == c) {
            image[sr][sc] = color;
        }
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, c, color);
        }
    }
}