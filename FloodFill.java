// Time Complexity: O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m;
    int n;
    int color;
    int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int newColor){
        // base
        if(r < 0 || c < 0 || r == m|| c == n|| image[r][c] != color) return;
        // logic
        image[r][c] = newColor;
        for(int[] dir : dirs){
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            dfs(image, newRow, newCol, newColor);
        }
    }
}