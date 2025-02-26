// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class FloodFillDFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int orgCol = image[sr][sc];

        if (orgCol == color) return image;
        dfs(image, sr, sc, orgCol, color, dirs);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int orgCol, int color, int[][] dirs) {
        // base
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || image[sr][sc] != orgCol) return;

        // logic
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, orgCol, color, dirs);
        }
    }
}