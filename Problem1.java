/*
    LC - https://leetcode.com/problems/flood-fill/description/
    TC - O(m * n)
    SC - O(m * n)
        recursive stack space
    Approach -
        Using DFS to recursively update the color
        check the boundary conditions.
*/

class Solution {
    int m, n;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L R
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void dfs(int[][] image, int row, int col, int color, int initialColor) {
        // base
        if(row < 0 || row ==m || col < 0 || col == n || image[row][col] != initialColor) {
            return;
        }

        // logic
        image[row][col] = color;
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(image, nr, nc, color, initialColor);
        }
    }
}