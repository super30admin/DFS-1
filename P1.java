/*
Flood Fill by DFS

TC - O(m x n)
SC - same as TC
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogColor = image[sr][sc];
        if (ogColor == color) return image;

        dfs(image, sr, sc, ogColor, color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int ogColor, int color) {
        // boundry check
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != ogColor) return;
        
        image[i][j] = color;

        dfs(image, i + 1, j, ogColor, color);
        dfs(image, i - 1, j, ogColor, color);
        dfs(image, i, j + 1, ogColor, color);
        dfs(image, i, j - 1, ogColor, color);
    }
}
