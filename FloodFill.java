class Solution {
    // Time Complexity : O(mn), where m is the no of rows and n is the no of columns
    // Space Complexity : O(mn)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using DFS
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int r;
    int c;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) {
            return image;
        }
        r = image.length;
        c = image[0].length;
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        dfs(image, sr, sc, color, newColor);
        return image;
    }


    public void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        for(int[] d : dirs) {
            int nr = sr + d[0];
            int nc = sc + d[1];

            if(nr >= 0 && nr < r && nc >= 0 && nc < c && image[nr][nc] == oldColor) {
                image[nr][nc] = newColor;
                dfs(image, nr, nc, oldColor, newColor);
            }
        }
    }
}