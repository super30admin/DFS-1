// Time Complexity : O(MXN)
// Space Complexity : O(MXN)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int[][] dirs;
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }
        m = image.length;
        n = image[0].length;
        dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        int oldColor = image[sr][sc];
        dfs(sr,sc,image,color,oldColor);
        return image;
    }
    
    void dfs(int row, int col,int[][] image, int color, int oldColor){
        if(row<0 || col<0 || row==m || col==n || image[row][col]!=oldColor) return;
        
        image[row][col] = color;
        for(int[] dir : dirs){
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            dfs(nr,nc,image,color,oldColor);
        }
    }
}