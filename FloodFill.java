// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * In this solution, we have applied DFS and it is an in-place algorithm where we are modifying the same image matrix
 * We apply dfs in all the four directions and color the old color with new color.
 */

class Solution {
    
    int[][] dirs;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int color = image[sr][sc];
        
        if(newColor == color) return image;
        
        dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        
        dfs(image, sr, sc, newColor, color);
        
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int color) {
        image[sr][sc] = newColor;
        
        for(int[] dir: dirs) {
            int cur_row = sr + dir[0];
            int cur_col = sc + dir[1];
            
            if(cur_row >= 0 && cur_col >= 0 && cur_row < image.length && cur_col < image[0].length && image[cur_row][cur_col] == color) {
                dfs(image, cur_row, cur_col, newColor, color);
            }
        }
    }
}

