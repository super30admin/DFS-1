// Time Complexity :O(m*n)
// Space Complexity :O(m*n) //visited array space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

class Solution {
    int[][] dirs;
    int color;
    boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0)
            return new int[0][0];
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int n = image.length;
        int m = image[0].length;
        visited = new boolean[n][m];
        this.color = image[sr][sc];
        dfs(image, sr, sc, n, m, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int n, int m, int newColor) {
        // base
        if (sr < 0 || sc < 0 || sr >= n || sc >= m || image[sr][sc] != color || visited[sr][sc])
            return;
        // logic
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        for (int[] dir : dirs) {
            int r = sr + dir[0], c = sc + dir[1];
            dfs(image, r, c, n, m, newColor);
        }
    }
}