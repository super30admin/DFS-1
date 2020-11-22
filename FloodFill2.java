/*
Author: Akhilesh Borgaonkar
Problem: LC 733. Flood Fill (DFS-1)
Approach: Using recursive DFS approach here.
Time Complexity: O(m*n) where m and n are vertical and horizontal length of image grid.
Space complexity: O(1) constant if we ignore the recursive stack.
LC verified.
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int oldColor = image[sr][sc];   //color of starting pixel
        
        if(oldColor != newColor)    //if the old and new colors are same then don't perform DFS
            dfsHelper(image, sr, sc, newColor, oldColor);   //else perform DFS on starting pixel
        
        return image;
        
    }
    
    private void dfsHelper(int[][] image, int sr, int sc, int newColor, int oldColor){
        
        //base case to handle edge cases and ignore the pixels whose color is not same as starting pixel's
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=oldColor)
            return;
        
        image[sr][sc]=newColor;                         //assign new color
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};  //directions array to ease the neighboring pixels lookup    
        
        for(int[] dir : dirs){
            int x = sr + dir[0];                    //get the neigboring coordinates of current pixel
            int y = sc + dir[1];
            dfsHelper(image, x, y, newColor, oldColor); //call recursive function on neighboring pixel
        }
        
    }
}