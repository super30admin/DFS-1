// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    int[][] dirs;
    int m,n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = image.length;
        this.n = image[0].length;

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        dfs(image, sr, sc, color, oldColor);

        return image;
    }

    private void dfs(int[][] image, int i , int j, int color, int oldColor){

        if(i < 0 || j < 0 || i == m || j == n || image[i][j] != oldColor) return;

        image[i][j] = color;

        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            dfs(image, r, c, color, oldColor);

        }
    }
}
