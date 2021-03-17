// Time Complexity :
O(N) where N is the pixels in the image 
// Space Complexity :
O(N) recursive call stack used in DFS
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //If the starting point of the click equals new color, then we need to return
        if(image[sr][sc] == newColor) return image;
        
        //To apply DFS call the recursive helper function
        helper(image, sr, sc, image[sr][sc], newColor);
        //After we fill, we will return the result
        return image;
    }
    
    //Since it's changing image itself, it's void
    private void helper(int[][] image, int sr, int sc, int startColor, int newColor){
        /*We need to check two things:
        1. Whether we are inside the given image
        2. whether the present position color is equal to my startColor
        */
        int row = image.length;
        int col = image[0].length;
        
        if(sr < 0 || sr >= row || sc < 0 || sc >= col || image[sr][sc] != startColor) 
        {
            return;
        }
        
        //Change color of the current pixel
        image[sr][sc] = newColor;
        
        /*Now we will continue to traverse around all the pixels around the current pixel using dfs */
        helper(image, sr-1, sc, startColor, newColor);
        helper(image, sr+1, sc, startColor, newColor);
        helper(image, sr, sc-1, startColor, newColor);
        helper(image, sr, sc+1, startColor, newColor);
    }
}