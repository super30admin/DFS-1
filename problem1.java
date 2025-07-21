// Time Complexity : O(n * m) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I used DFS to solve this problem. The idea is to start from the pixel that needs to be changed and recursively change the color of all connected pixels that have the same original color. The recursion will explore all four directions (up, down, left, right) to ensure that all connected pixels are updated.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        if (image[r][c] != originalColor) {
            return;
        }
        image[r][c] = newColor;
        if (r >= 1) dfs(image, r - 1, c, originalColor, newColor); 
        if (c >= 1) dfs(image, r, c - 1, originalColor, newColor);
        if (r + 1 < image.length) dfs(image, r + 1, c, originalColor, newColor);
        if (c + 1 < image[0].length) dfs(image, r, c + 1, originalColor, newColor); 
    }
}
