class Solution {

    //TC: O(m*n)
    //SC: O(m*n)
    int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;
        int m = image.length;
        int n = image[0].length;

        this.dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        if(image[sr][sc] == newColor) return image;
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor, oldColor, m, n);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor, int m, int n){
         //base
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != oldColor) return;
         //logic
         image[sr][sc] = newColor;
         for(int [] dir: dirs){
             int nr = dir[0] + sr;
             int nc = dir[1] + sc;
             dfs(image,nr,nc,newColor, oldColor, m,n);
         }   
    }
}
