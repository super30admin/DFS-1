//TC: O(m X n)
//SC: O(height)

class Solution {
    int m, n;
    int[][] dirs;
    int oldColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color)
        return image;

        m = image.length;
        n = image[0].length;
        dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        oldColor = image[sr][sc];

        dfs(image, sr, sc, color);

        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color){
        if(sr<0 || sc<0 || sr == m || sc == n || image[sr][sc] != oldColor) return;

        image[sr][sc] = color;
        for(int[] dir: dirs){
            int row = sr + dir[0];
            int column = sc + dir[1];
            dfs(image, row, column, color);
        }
    }

}
