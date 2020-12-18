// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class FloodFillSolution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int newColor, int oldColor) {
        int m = image.length, n = image[0].length;
        if(r>=m || r<0 || c>=n || c<0 || image[r][c] != oldColor)
            return;
        image[r][c] = newColor;
        dfs(image, r+1, c, newColor, oldColor);
        dfs(image, r-1, c, newColor, oldColor);
        dfs(image, r, c+1, newColor, oldColor);
        dfs(image, r, c-1, newColor, oldColor); 
    }
}