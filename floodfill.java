// Time Complexity : O(m x n)
// Space Complexity : O( m x n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m, n; // globally initialise number of rows and cols
    int[][] dirs; // direction matrix

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }
        m = image.length; // rows
        n = image[0].length; // cols
        int initialColor = image[sr][sc]; // getting the initial colour
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // U D L R
        dfs(image, sr, sc, initialColor, color);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int initialColour, int color) {
        if(row < 0 || col < 0 || row == m || col == n || image[row][col] != initialColour){
            return; // base case
        }
        image[row][col] = color;
        for(int dir[] : dirs){ // recursive for loop
            int nr = row + dir[0]; // getting the U/D/L/R index
            int nc = col + dir[1];
            dfs(image,  nr,  nc, initialColour , color); // recursion dfs
        }
    }
}