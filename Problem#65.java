// Flood Fill

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0)
            return image;
        m = image.length;
        n = image[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        if(image[sr][sc] == newColor) return image;
        int color = image[sr][sc];
        dfs(image, sr, sc, newColor, color, dirs, m, n);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int newColor, int color, int[][] dirs, int m, int n){
        //base
        if(r < 0 || c < 0 || r == m || c == n || image[r][c] != color) return;
        //logic
        image[r][c] = newColor;
        for(int[] dir:dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(image, nr, nc, newColor, color, dirs, m , n);
        }
    }
}