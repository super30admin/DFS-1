//time o(n)
//space o(n)

class Solution {
    class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
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
        if(currColor == newColor) {
            return image;
        }
        dfs(image, sr, sc, newColor, currColor);
        return image;
    }
    
    public void dfs(int[][] image, int i, int j, int newColor, int currColor) {
        if(i<0 || i==image.length || j<0 || j==image[0].length || image[i][j] != currColor) {
            return;
        }
        // if(image[i][i] == currColor) {
            image[i][j] = newColor;
            dfs(image, i+1, j, newColor, currColor);
            dfs(image, i-1, j, newColor, currColor);
            dfs(image, i, j+1, newColor, currColor);
            dfs(image, i, j-1, newColor, currColor);
        // }
    }
}
