// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class Solution {
    int[][] dirs;
    int m;
    int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color)
            return image;

        dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        m = image.length;
        n = image[0].length;
        int Oldcolor = image[sr][sc]; // obtaining the old color to check later on

        dfs(sr, sc, image, color, Oldcolor);
        return image;

    }

    private void dfs(int row, int column, int[][] image, int color, int Oldcolor) {
        // base
        if (row < 0 || row > m || row == m || column < 0 || column > n || column == n || image[row][column] != Oldcolor)
            return;

        // logic
        image[row][column] = color; // changing the current cells color to color
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = column + dir[1];
            dfs(nr, nc, image, color, Oldcolor); // performing dfs on the cells neighboring the cell by 4 sides and
                                                 // having the value of oldcolor.
        }
    }
}