// Time Complexity: O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m;
    int n;
    int color;
    int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // if the given index in matrix is the target color then return the matrix
        if(image[sr][sc] == newColor) return image;
        // get number of rows and columns
        m = image.length;
        n = image[0].length;
        // get the color at the given index
        color = image[sr][sc];
        // call dfs
        dfs(image, sr, sc, newColor);
        // return the matrix
        return image;
    }
    private void dfs(int[][] image, int r, int c, int newColor){
        // base
        // check for boundary conditions and if the cell is of original color
        if(r < 0 || c < 0 || r == m|| c == n|| image[r][c] != color) return;
        // logic
        // change the color and call dfs for each index formed by dirs array
        image[r][c] = newColor;
        for(int[] dir : dirs){
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            dfs(image, newRow, newCol, newColor);
        }
    }
}
