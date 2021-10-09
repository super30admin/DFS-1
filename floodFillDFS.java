// Time Complexity : O(n)
// Space Complexity : O(n), stack used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Tried to implement DIRS array but found this more intuitive.
// Is that okay to do?


public class floodFillDFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        
        return image;
    }
    
    public void dfs(int[][] image, int row, int col, int color, int newColor) {
        // if it's the old color, change to new color and fill adjacent cells
        if(image[row][col] == color){
            image[row][col] = newColor;
            if (row >= 1)                   dfs(image, row-1, col, color, newColor);
            if (col >= 1)                   dfs(image, row, col-1, color, newColor);
            if (row+1 < image.length)       dfs(image, row+1, col, color, newColor);
            if (col+1 < image[0].length)    dfs(image, row, col+1, color, newColor);
        }
    }
    
}
