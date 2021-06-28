// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
// Go over given initial element in matrix then check all its neighbors from dirs array and check their neighbors recursively
// This will create a ripple from the point given and check all the points unless it hits 0s or 2s

class Solution {
    int color;
    int m;
    int n;
    int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        color = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{0,1},{0,-1},{-1,0}, {1,0}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int newColor){
        //base color
        if(r < 0 || c < 0 || r == m || c == n || image[r][c] != color) return;
        //logic
        image[r][c] = newColor;
        for(int [] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(image, nr, nc, newColor);
        }        
        
    }
}