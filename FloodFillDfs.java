// Time Complexity : O(m * n)
// Space Complexity : O(m * n)

class Solution {
    int[][] dirs;
    int m, n;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int newColor){
        image[sr][sc] = newColor;
         for(int[] dir : dirs){
                int r = sr + dir[0];
                int c = sc + dir[1];
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == color)
                   dfs(image, r, c, newColor);
            }
    }
}