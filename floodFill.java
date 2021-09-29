// Time Complexity : O(n)  
// Space Complexity :O(n)   
// Did this code successfully run on Leetcode : yes
class Solution {
    int m; int n; int color; int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];
        //image[sr][sc] = newColor;
        //row.add(sr); column.add(sc);
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor){
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        for(int [] dir : dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor);
        }
    }
}