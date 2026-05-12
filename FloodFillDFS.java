// Time Complexity :   O(m * n) where m is number of rows and n is number of columns in the matrix. We are processing each cell at most once.
// Space Complexity : O(m * n) for the recursion stack in worst case when all cells are connected and we are doing DFS from one cell and processing all cells in the matrix.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// DFS approach
// 1. Change starting cell color and start DFS from starting cell
// 2. Explore 4 directions and if we encounter a cell with original color, we change its color and continue DFS from that cell
// 3. Return the matrix after processing all reachable cells with original color    
// Note: This approach is optimal as we are doing DFS from starting cell and processing all reachable cells with original color. Hence, it will not lead to time out exception for large matrices.
class Solution {

    int m, n;

    int[][] directions = new int[][]
    {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        m = image.length;
        n = image[0].length;

        int originalColor = image[sr][sc];

        // No need to process
        if (originalColor == color) {
            return image;
        }

        helper(image, sr, sc, color, originalColor);

        return image;
    }

    public void helper(int[][] image, int sr, int sc,
                       int color, int originalColor) {

        // Color current cell
        image[sr][sc] = color;

        // Explore 4 directions
        for (int[] dir : directions) {

            int nr = sr + dir[0];
            int nc = sc + dir[1];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                image[nr][nc] == originalColor) {

                helper(image, nr, nc, color, originalColor);
            }
        }
    }
}