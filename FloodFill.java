// Time Complexity : O(m*n) where m*n is the size of the matrix.
// Space Complexity : O(m*n) auxiliary recursion stack space, but the actual space complexity would be O(1) if not considering the recursive stack space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    private void dfs(int row, int col, int[][] image, int color, int orignalColor)
    {
        image[row][col] = color;
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int i=0; i<dir.length; i++)
        {
            int nrow = row + dir[i][0];
            int ncol = col + dir[i][1];
            if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length && image[nrow][ncol] == orignalColor)
                dfs(nrow, ncol, image, color, orignalColor);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orignalColor = image[sr][sc];
        if(color == orignalColor)
            return image;
        dfs(sr, sc, image, color, orignalColor);
        return image;
    }
}