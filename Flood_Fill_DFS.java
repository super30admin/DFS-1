//TC : O(m * n)
//SC : O(m * n)
// DFS
class Solution {
    int m;
    int n;
    int dirs[][];
    private void dfs(int[][] image, int sr, int sc, int color, int oldColor) {
        
        
        for(int[] x : dirs) {
            int nr = sr + x[0];
            int nc = sc + x[1];
            if(nr < m && nr >= 0 && nc < n && nc >= 0 &&
               image[nr][nc] == oldColor) {
                image[nr][nc] = color;
                dfs(image, nr, nc, color, oldColor);
            }
        }
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image == null || image[0].length == 0 || image[sr][sc] == color)
            return image;
        
         m = image.length;
         n = image[0].length;
        dirs = new int[][]{{0,-1}, {-1, 0}, {0, 1}, {1, 0}};        
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        
        dfs(image, sr, sc, color, oldColor);
        
        return image;
        
    }
}
