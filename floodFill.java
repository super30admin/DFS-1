// Time Complexity : O(rows * cols) 
// Space Complexity : O(rows * cols)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : forgot to include the edge case of checking whether the 
// current pixel equals the newColor.

// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        dfs(image, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
    
    public void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
        
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor || image[i][j] == newColor)
            return;
        image[i][j] = newColor;
        
        dfs(image, i + 1, j, oldColor, newColor);
        dfs(image, i, j + 1, oldColor, newColor);
        dfs(image, i - 1, j, oldColor, newColor);
        dfs(image, i, j - 1, oldColor, newColor);
        
    }
    
}