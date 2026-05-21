// https://leetcode.com/problems/flood-fill/
// Time Complexity : O(m * n) where m is the number of rows and n is the number of columns in the image.
// Space Complexity : O(m * n) in the worst case, due to the recursive call stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        if (image[sr][sc] == color)
            return image;
        int originalColor = image[sr][sc];
        dfs(image, sr, sc, dirs, originalColor, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int[][] dirs, int originalColor, int color) {
        // base case
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || image[sr][sc] != originalColor)
            return;

        // logic
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            dfs(image, sr + dir[0], sc + dir[1], dirs, originalColor, color);
        }
    }
}