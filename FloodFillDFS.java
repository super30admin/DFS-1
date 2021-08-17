// DFS

// TC: O(m x n)
// SC: O(m x n)
class Solution {
    int m, n, color;
    int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        color = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        helper(image, newColor, sr, sc);
        return image;
    }
    private void helper(int[][] image, int newColor, int r, int c) {
        if(r < 0 || r >= m || c < 0 || c >= n || image[r][c] != color) {
            return;
        }
        image[r][c] = newColor;
        for(int[] d : dirs) {
            int nRow = r + d[0];
            int nCol = c + d[1];
            helper(image, newColor, nRow, nCol);
        }
    }
}