// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use DFS traversal to go to all 4 directions 
// If color is the src colore change it to new
// For exit condition check the if the indexes are within the box
// We will also exit when current color is not src color and src color is not the new color

class Solution {
    int[][] directions = {{-1, 0},{1, 0}, {0, -1}, {0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        floodFill(image, sr , sc, newColor, image[sr][sc]);
        return image;
    }
    private void floodFill(int[][] image, int sr, int sc, int newColor, int srcclr){
        //exit conditions
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != srcclr || newColor == srcclr){
            return;
        }
        //change color
        image[sr][sc] = newColor;
        //explore all directions
        for(int[] direc: directions){
            int newsr = sr + direc[0];
            int newsc = sc + direc[1];
            floodFill(image, newsr , newsc, newColor, srcclr);
        }
        
        
    }
}