// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
//Use DFS to change the old color to new color and return the updated matrix
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor!=newColor)
            colorImage(image,sr,sc,newColor,oldColor);
        return image;
    }
    
    public void colorImage(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc] != oldColor)
            return;
        
        image[sr][sc] = newColor;
        
        colorImage(image,sr+1,sc,newColor,oldColor);
        colorImage(image,sr-1,sc,newColor,oldColor);
        colorImage(image,sr,sc+1,newColor,oldColor);
        colorImage(image,sr,sc-1,newColor,oldColor);

    }
}