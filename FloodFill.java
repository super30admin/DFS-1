// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(mn) since we are iterating through the entire 2D matrix
//Space Complexity: O(1) since we have not used ay extra space

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
         
        int currColor = image[sr][sc];
        
        if(currColor != newColor){
            helper(image, sr, sc, currColor, newColor);   
        }       
      return image;
    }
    
    public void helper(int[][] image, int sr, int sc, int currColor, int newColor){
        
        //Base Case
        
        if(sr < 0 || sr > image.length-1 || sc <0 || sc > image[0].length-1 || image[sr][sc] != currColor)
        {
            return;
        }

        image[sr][sc] = newColor;
        
        //Up
        helper(image, sr-1, sc, currColor, newColor);
        
        //Down
        helper(image, sr+1, sc, currColor, newColor);
        
        //Right
        helper(image, sr, sc+1, currColor, newColor);
        
        //Left
        helper(image, sr, sc-1, currColor, newColor);
    }
}