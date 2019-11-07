// Daily Problem #62
// Time Complexity : O(n)
// Space Complexity : O(1) (if we consider call Stack then O(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
//  At first my code was not ending because my base case logic was incorrect.
//  Once I fixed this my solution worked 

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return helper(image, sr, sc, newColor, image[sr][sc]);           
    }
    public int[][] helper(int[][] image, int sr, int sc, int newColor, int originalColor) {
        
        if(image[sr][sc] == newColor || image[sr][sc] != originalColor) return image;
        
        image[sr][sc] = newColor;
        //four directions                                        
        int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
        for(int[] direction : directions){
            int row = sr + direction[0];
            int col = sc + direction[1];
            if(row >= 0 && row < image.length 
               && col >= 0 && col < image[row].length){
                image = helper(image, row, col, newColor, originalColor);
            }
        }
        return image;   
    }
}
