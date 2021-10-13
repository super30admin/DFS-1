//dfs dolution
// tc O(m*n)
//sc O(1)

class Solution {
    int color;
    int m;
    int n;
    int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        color = image[sr][sc];
        m = image.length;
        n = image[0].length;
        
        dirs = new int [][] {{0,1},{0,-1},{-1,0},{1,0}};
        
        dfs(image, sr, sc , newColor);
        return image;
        
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor) {
        
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color ) return;
        
        image[sr][sc] = newColor;
        for(int [] dir: dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c , newColor);
        }
        
    }
}
