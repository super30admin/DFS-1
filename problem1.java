// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes

/*
 * Approach 
 * We are using DFS here with the directions array 
 * to keep track of which color of change we store them first
 * and start the dfs
 * in dfs image, row , col, color , oldcolor and the dirs array is passed
 * we check all the immediate neighbours using the dirs array and continue the dfs
 * if we encounter the  iamge that is already changed or row,col are out of bound we return
 * 
 * finally we return image
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        if (image[sr][sc] == color)
            return image;
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, color, oldColor, dirs);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int oldColor, int[][] dirs) {
        // base
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color, oldColor, dirs);
        }
    }
}