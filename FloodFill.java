// Time Complexity : O(m*n) where m is number of rows and n is number of columns
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem1 (https://leetcode.com/problems/flood-fill/)

// You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
// To perform a flood fill:
// Begin with the starting pixel and change its color to color.
// Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
// Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
// The process stops when there are no more adjacent pixels of the original color to update.
// Return the modified image after performing the flood fill.

// Example 1:
// Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
// Output: [[2,2,2],[2,2,0],[2,0,1]]

// Example 2:
// Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
// Output: [[0,0,0],[0,0,0]]

// Constraints:
// m == image.length
// n == image[i].length
// 1 <= m, n <= 50
// 0 <= image[i][j], color < 216
// 0 <= sr < m
// 0 <= sc < n

class Solution {
    int m, n;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Edge case: if image is null or empty or the starting pixel already has the desired color
        if (image == null || image.length == 0 || image[sr][sc] == color){
            return image;
        }

        m = image.length;
        n = image[0].length;

        // Direction vectors for Up, Down, Left, Right
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L R
        int oldColor = image[sr][sc]; // color to be replaced
        dfs(image, sr, sc, color, oldColor); // starting DFS from (sr, sc)

        return image; // return modified image
    }

    private void dfs(int[][] image, int row, int col, int color, int oldColor){
        // BASE CASE: out of bounds or current cell is not of the color we're replacing
        if (row < 0 || row == m || col < 0 || col == n || image[row][col] != oldColor){
            return;
        }

        // LOGIC

        // Replacing the color
        image[row][col] = color;

        // Exploring all 4 directions
        for (int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];

            dfs(image, nr, nc, color, oldColor);
        }
    }
}
