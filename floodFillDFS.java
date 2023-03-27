
class Solution {
    int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        dirs  = new int[][] {{-1,0}, {0,1}, {1,0}, {0,-1}};
        int color = image[sr][sc];
        dfs(image, sr, sc, newColor, m, n, color);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int m, int n, int color){
        //null
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color) return;
        //logic
        image[sr][sc] = newColor;
        for(int [] dir: dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor, m,n,color);
        }
    }
}
