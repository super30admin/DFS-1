// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


class Solution {
    int [][] dirs;
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if( image == null || image.length == 0 || image[sr][sc] == newColor)return image;
        oldColor = image[sr][sc];
        dirs = new int [][] {{1,0},{0,1},{-1,0},{0,-1}};
        dfs(image,sr,sc,newColor);
        return image;       
    }
    private void dfs(int[][] image, int sr, int sc, int newColor){
        
        if(sr>=image.length || sc >= image[0].length || sr < 0 || sc < 0 || image[sr][sc] != oldColor)return;
        
        image[sr][sc] = newColor;
        for(int [] dir : dirs){
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(image,r,c,newColor);
        }
    }
}