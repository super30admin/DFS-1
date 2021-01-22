// Time Complexity : 0(m*n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    int color, m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        color = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor){
        if(sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != color)
            return;
        image[sr][sc] = newColor;
        dfs(image, sr, sc - 1, newColor);
        dfs(image, sr, sc + 1, newColor);
        dfs(image, sr - 1, sc, newColor);
        dfs(image, sr + 1, sc, newColor);
    }
}