class Solution {
    
    class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }     
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int currColor = image[sr][sc];
        
        if(newColor == currColor) {
            return image;
        }
        
        dfs(image, sr, sc, newColor, currColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int currColor) {
     
        if(sr == image.length || sr < 0 || sc ==image[0].length || sc < 0 || image[sr][sc] != currColor)
        {
            return;
        }
        
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        image[sr][sc] = newColor;
        
        for(int[] dir: dirs) {
            int row = sr + dir[0];
            int col = sc + dir[1];
            
            dfs(image, row, col, newColor, currColor);
            
        }
    }     
}