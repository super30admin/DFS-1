// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Base case: if the starting pixel has the same color as the newColor, no need to flood fill
        if (image[sr][sc] == newColor) {
            return image;
        }

        // Get the original color of the starting pixel
        int originalColor = image[sr][sc];

        // Perform flood fill using depth-first search
        dfs(image, sr, sc, originalColor, newColor);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        // Check if the current position is within the image boundaries and has the original color
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != originalColor) {
            return;
        }

        // Change the color of the current pixel
        image[row][col] = newColor;

        // Explore neighbors in 4 directions
        dfs(image, row - 1, col, originalColor, newColor); // Up
        dfs(image, row + 1, col, originalColor, newColor); // Down
        dfs(image, row, col - 1, originalColor, newColor); // Left
        dfs(image, row, col + 1, originalColor, newColor); // Right
    }
}