// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[sr][sc] == newColor){
            return image;
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0}, {1,0}};
        int m = image.length;
        int n = image[0].length;
        dfs(image, sr,sc,newColor,image[sr][sc], m,n, dirs);
        return image;
    }
    
    void dfs(int[][] image, int sr, int sc, int newColor, int color,int m, int n, int[][] dirs){
        //base
        if(sr==m || sr<0||sc<0 || sc ==n|| image[sr][sc] != color){
            return;
        }
            
        //logic
        image[sr][sc]= newColor;
        for(int[] dir : dirs){
            int nr = sr+dir[0];
            int nc = sc+dir[1];
            dfs(image, nr, nc, newColor, color, m,n, dirs);
        }
        
    }
    
}