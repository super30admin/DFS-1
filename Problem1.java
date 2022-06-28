// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//733. Flood Fill
//https://leetcode.com/problems/flood-fill/

class Solution {
    // DFS Approach
    // time:
    // space:
    int m = 0;
    int n = 0;
    int imageT;
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        imageT = image[sr][sc];
        if (image[sr][sc] == color)
            return image;
        image[sr][sc] = color;
        dfs(image, sr, sc, color);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color) {
        // base
        if (sr < 0 && sc < 0 && sr > m && sc > n)
            return;

        // logic
        for (int[] dir : dirs) {
            int row = sr + dir[0];
            int col = sc + dir[1];
            if ((row >= 0 && col >= 0 && row < m && col < n) && (image[row][col] == imageT)) {
                image[row][col] = color; // System.out.println(image[row][col] + " row: " + row + " col: " + col);
                dfs(image, row, col, color);
            }
        }
    }
}