// Time Complexity : O(m * n) --> where m & n are lengths of input 2D matrix
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode (733): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    // DFS Approach
    int dirs [][];
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // edge case
        if (image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        color = image[sr][sc];
        dirs = new int [][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor) {
        // base case
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        
        // logic
        image[sr][sc] = newColor;
        for (int dir[] : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c, newColor);
        }
    }
}