// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    
    int color;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
        
    }
    
    private void dfs(int[][] image, int row, int col, int newColor) {
        
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != color || image[row][col] == newColor) {
            return;
        }
        
        image[row][col] = newColor;
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(image, r, c, newColor);
        }
        
    }
}