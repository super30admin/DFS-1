// Time Complexity : O(m*n); where m = numbers of rows and n = number of columns in the input matrix
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int color;
    int [][] dirs; 
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        
        // 4-direction neighbors
        dirs = new int [][] {{0,1}, {-1,0}, {1,0}, {0,-1}};
        
        // find number of rows and columns in the image matrix
        int m = image.length;
        int n = image[0].length;
        
        // store the original color of the starting cell
        color = image[sr][sc];
        
        dfs(image, sr, sc, newColor, m, n);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int m, int n){
        // base
        if(sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc] != color) return;
        
        // logic
        image[sr][sc] = newColor;
        for(int[] dir : dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor, m, n);
        }
        
    }
}