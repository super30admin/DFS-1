// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : used DP instead of a brute force BFS approach


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];

        // Initialize result array
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = (mat[i][j] == 0) ? 0 : Integer.MAX_VALUE - 1000; // -1000 to avoid overflow during +1 operations.

        // First pass (Top-left to Bottom-right):
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (result[i][j] != 0) {
                    if (i > 0) result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                    if (j > 0) result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                }
                    

        // Second pass (Bottom-right to Top-left):
        for (int i = rows - 1; i >= 0; i--)
            for (int j = cols - 1; j >= 0; j--)
                if (result[i][j] != 0) {
                    if (i < rows - 1) result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                    if (j < cols - 1) result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }

        return result;        
    }
}