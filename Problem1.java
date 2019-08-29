// Time Complexity : O(n) - n is equal to number of elements in worst case when all elements need to be updated
// Space Complexity : O(1) - ? 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to see solution on leetcode

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color != newColor){
        helper(image, sr, sc, color, newColor);
        }
        return image;
    }
    
    public void helper(int[][]image, int r, int c, int color, int newColor){
        if(image[r][c] == color){
            image[r][c] = newColor;
            if(r > 0){
                helper(image, r-1, c, color, newColor);
            }
            if(c > 0){
                helper(image, r, c-1, color, newColor);
            }
            if(r < image.length-1){
                helper(image, r+1, c, color, newColor);
            }
            if(c < image[0].length-1){
                helper(image, r, c+1, color, newColor);
            }
            
        }
    }
}