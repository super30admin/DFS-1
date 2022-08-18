// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0) return image;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        dfs(image, sr, sc, newColor, color, dirs, m, n);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int newColor, int color, int[][] dirs, int m, int n) {
        // base
        if( i < 0 || i == m || j < 0 || j == n || image[i][j] != color) return;
        
        // logic
        image[i][j] = newColor;
        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(image, r, c, newColor, color, dirs, m, n);
        }
    }
}