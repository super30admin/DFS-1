// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    int m; int n; int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        //set up row and col int
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];
        //start dfs
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color) return;
        //logic
        //make the new color
        image[sr][sc] = newColor;
        //set up a direction array
        int [][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        //iterate on the directions
        for(int [] direc : dirs){
            int row = direc[0] + sr;
            int col = direc[1] + sc;
            //call dfs on image, row, col, and the new color
            dfs(image, row, col, newColor);
        }

    }
} 