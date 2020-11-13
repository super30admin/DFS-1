//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.LinkedList;
import java.util.Queue;

//Use BFS or DFS approach to solve this problem as the time and space complexity will be O(m*n) for both approaches.
class Flood_Fill_733 {
    int color; // Initial color
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	// If the input matrix is empty or the image at the given location is newColor, then return image matrix
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        // Store the initial color in the color variable
        color = image[sr][sc];
        // Define dirs array
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        // Define Queue with type parameter as int[] to hold the row and column index of the matrix elements
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc}); // Add the row and column index of the given location to start with
        image[sr][sc] = newColor; // Update the color with newColor i.e, perform flood filling
        
        while(!q.isEmpty())
        {
        	// Store the Queue element in temp array and delete from the Queue
            int[] temp = q.poll();
            
            // Iterate through all the neighbors of the current element of the image matrix
            for(int[] dir : dirs)
            {
                int row = temp[0] + dir[0];
                int col = temp[1] + dir[1];
                
             // Check the boundary conditions and check whether the element's color is initial color
                if(row >= 0 && col >= 0 && row < image.length && col < image[0].length && image[row][col] == color)
                {
                	// Update the color of the current element with the newColor
                    image[row][col] = newColor;
                    q.add(new int[] {row, col}); // Add the new location into the Queue
                }
            }
        }
        return image;
    }
}
