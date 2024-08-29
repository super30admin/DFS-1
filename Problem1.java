// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Get the initial color of the starting pixel
        int initialColor = image[sr][sc];
        
        // If the initial color is the same as the new color, no change is needed
        if (initialColor != color) {
            // Start the DFS from the starting pixel
            dfs(image, sr, sc, initialColor, color);
        }
        
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int initialColor, int newColor) {
        // Check if the current position is out of bounds or if the color does not match
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != initialColor) {
            return;
        }
        
        // Change the color of the current pixel
        image[sr][sc] = newColor;
        
        // Recursively apply DFS in all 4 directions
        dfs(image, sr + 1, sc, initialColor, newColor); // Down
        dfs(image, sr - 1, sc, initialColor, newColor); // Up
        dfs(image, sr, sc + 1, initialColor, newColor); // Right
        dfs(image, sr, sc - 1, initialColor, newColor); // Left
    }
}
