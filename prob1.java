import java.util.*;

class Solution {
    // Helper DFS function to explore and fill the image
    private void dfs(int row, int col, int[][] image, int newColor, int[][] ans, int[] delRow, int[] delCol, int iniColor) {
        // Color the current cell with the new color
        ans[row][col] = newColor;
        
        // Explore all four neighbors (up, right, down, left)
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            // Check if the new position is valid and matches the initial color
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                // Recurse for valid neighbor
                dfs(nrow, ncol, image, newColor, ans, delRow, delCol, iniColor);
            }
        }
    }

    // Main flood fill function
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Get the initial color at the starting point
        int iniColor = image[sr][sc];

        // If the initial color is the same as the new color, no need to change anything
        if (iniColor == newColor) {
            return image;
        }

        // Create a copy of the image to avoid modifying the original
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            System.arraycopy(image[i], 0, ans[i], 0, image[i].length);
        }

        // Directions for 4 neighbors (up, right, down, left)
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // Start DFS from the initial point
        dfs(sr, sc, image, newColor, ans, delRow, delCol, iniColor);
        
        return ans;
    }

    // Main method to test the flood fill
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        // Start at (1, 1) and change color to 2
        Solution obj = new Solution();
        int[][] ans = obj.floodFill(image, 1, 1, 2);

        // Print the result
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
