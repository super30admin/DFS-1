// Time Complexity : O(m * n) i.e. total number of pixels into image where m = number of rows, n = number of columns
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[sr][sc] == newColor)  return image;
        
        helper(sr, sc, image, image[sr][sc], newColor);
        
        return image;
        
    }
    
    int [][]dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    
    private void helper(int i, int j, int[][] image, int color, int newColor){
        
        //base case
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length ||
            image[i][j] != color){
            return;
        }
        
        image[i][j] = newColor;
        
        for(int dir[]: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            helper(r, c, image, color, newColor);
        }
    }
}
