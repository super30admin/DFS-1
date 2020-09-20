/*
 * #733. Flood Fill
 * 
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
	
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.

Note:

1. The length of image and image[0] will be in the range [1, 50].
2. The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
3. The value of each color in image[i][j] and newColor will be an integer in [0, 65535].

*/


/*
 * Time Complexity: O (m*n) -> Traversing through all the cells in matrix while exploring branches/directions
 * 
 * Space Complexity: O (m*n) -> Recursive stack to store the pixels in matrix not all at the same time
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DFS1;

public class FloodFill {
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        // #1. Base condition
        if(image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor){
            return image;
        } 
        
        // #2. Initiate the recursive call -> explore all the branches from starting pixel
        recurr(image, sr, sc, image[sr][sc], newColor);
        // After done exploring all the branches, return the flood filled image
        return image;
        
    }
    
    // #3. Create a global direction array to explore the branches
    int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    
    // Recursive function to explore all the branches from starting pixel
    public void recurr(int[][] image, int i, int j, int oldColor, int newColor){
        // #4. Change the current pixel to newColor
        image[i][j] = newColor;
        
        // #5. Explore the branches/directions we can go from starting pixel and so on...
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            // #6. Check if new direction is in bounds and the pixel value at new direction is oldColor, if yes, then only make a recursive call
            if(r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == oldColor){
                // only matrix, sr and sc will change, old and new color remains same
                recurr(image, r, c, oldColor, newColor);
            }
        }
        
    }
    
}
