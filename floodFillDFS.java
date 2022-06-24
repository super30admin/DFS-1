// https://leetcode.com/problems/flood-fill/submissions/

// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

// ---------------------------- DFS --------------------------------------

class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor) return image;
        int m = image.length; // row
        int n = image[0].length; // column
        int color = image[sr][sc];
        dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        dfs(image, sr, sc, newColor, m, n, color);
       
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int m, int n, int color) {
         
        // Base condition
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color) return;
        
        // Logic
        image[sr][sc] = newColor;
         for (int[] dir : dirs) {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;

             dfs(image, nr, nc, newColor, m, n, color);
            }
        }
    }
