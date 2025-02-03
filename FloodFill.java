// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int [][] dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null || image.length==0 || image[sr][sc]==color){
            return image;
        }
        m = image.length;
        n = image[0].length;
        dirs = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
        dfs(image,  sr,  sc,  color,  image[sr][sc]);
        return image;
    }
    private void dfs(int[][]image, int sr, int sc, int color, int oldColor){
        //base
        if(sr<0 || sr == m || sc < 0 || sc == n || image[sr][sc] != oldColor){
            return;
        }
        //logic
        image[sr][sc]=color;
        for(int [] dir : dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color, oldColor);
        }
    }
}