// 733. Flood Fill - https://leetcode.com/problems/flood-fill/
// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int color, m, n;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        color = image[sr][sc];
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        m = image.length;
        n = image[0].length;
        
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor){
        // base
        if(sr == m || sc == n || sc < 0 || sr < 0 || image[sr][sc] != color) return;
        // logic
        image[sr][sc] = newColor;
        for(int[] dir : dirs){
            int r = sc + dir[0];
            int c = sr + dir[1];
            dfs(image, r, c, newColor);
        }
    }
}