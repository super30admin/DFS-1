class Solution {
    int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (color != oldColor) {
            image[sr][sc] = color;
            dfs(image, sr, sc, color, oldColor);
        }
        return image;
    }
    private void dfs(int[][]image, int i, int j, int newcolor, int oldColor)
    {
        for(int[] direction: directions)
        {
            int r = i + direction[0];
            int c = j + direction[1];
            if(r >=0 && c >= 0 && r < image.length && c < image[0].length && image[r][c] == oldColor)
            {
                image[r][c] = newcolor;
                dfs(image, r, c, newcolor, oldColor);
            }
        }
    }
}
