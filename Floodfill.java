// Problem 733. Flood Fill
// Time Complexity : O(m*n)
// Space Complexity : O(m*h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Floodfill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null){
            return image;
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        int startColor = image[sr][sc];
        if(startColor == color){
            return image;
        }
        dfs(image, sr, sc, color, startColor, dirs);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int color, int startColor, int[][] dirs){
        // base
        if(r < 0 || c < 0 || r == image.length || c == image[0].length || image[r][c] != startColor){
            return;
        }
        // logic
        image[r][c] = color;
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(image, nr, nc, color, startColor, dirs);
        }
    }
}
