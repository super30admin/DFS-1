// Time Complexity: O(mn)
// Space Complexity: O(mn)
// Did this code successfully run on Leetcode : Yes
//DFS Solution


public class FloodFill {
    int[][] dirs;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // null case
        if(image == null || image[sr][sc] == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        dirs = new int [][] {{0,1}, {0,-1}, {-1,0}, {1,0}};
        color = image[sr][sc];
        dfs(image, sr, sc, m, n, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int m, int n, int newColor) {
        //base case
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color) return;
        //logic
        image[sr][sc] = newColor;
        for(int[] dir: dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, m, n, newColor);
        }
    }
}
