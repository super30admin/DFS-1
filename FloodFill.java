// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We use DFS to explore all possible cells where the color needs to be changed. Further in order to avoid excess space, we would be negating the values of the new color
*/

class Solution {
    
    int color;
    int newColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int x) {
        
        color = image[sr][sc];
        newColor = x;
        
        dfs(image, sr, sc);
        
        for (int i=0; i<image.length; i++){
            for (int j=0; j<image[0].length; j++){
                if (image[i][j] == -1*newColor){
                    image[i][j] = newColor;
                }
            }
        }
        
        return image;
    }
    
    public void dfs(int[][] image, int r, int c){
        
        if (r<0 || c<0 || r>=image.length || c>=image[0].length) return;
        
        if (image[r][c] == color) {
            image[r][c] = -1*newColor;
        
            int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

            for (int[] dir : dirs)
                dfs(image, r+dir[0], c+dir[1]);
        }
    }
    
}