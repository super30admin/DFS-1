package Nov12;

import java.util.LinkedList;
import java.util.Queue;

class FloodFill {
	
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
/*
  Time Complexity: O(m*n) where m is number of rows and n is number of columns in image grid.
  Because we will iterate through all the nodes of image grid if they all have an initial color and later get colored with new color.
  
  Space Complexity: O(m*n)
  Because from 1 new colored node, 4 neighbor nodes can get the new color. Each of those 4 nodes can further color 4*4 neighbor nodes. This can very soon cover the entire grid of m*n.  
 
  Did this code successfully run on Leetcode : Yes
 
  Any problem you faced while coding this : No
     
  Approach: 
  BFS approach taken.
                        
*/ 
        
        // edge case
        if (image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        
        int m = image.length;
        int n = image[0].length;
        
        // creating queue for BFS and adding the row and column of the cell to start the traversal
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
  
        // finding initial color of the cell to start the traversal and keep it in 'color' variable
        // set this cell value with new color 
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        // BFS traversal of the given matrix by polling one queue element
        // set all its neighbors to new color
        // Also add neighbors of this polled element to the BFS queue
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir: dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
// NOTE: Change value of neighbor cells to new color value before putting inside the BFS queue to avoid repeated entries in the queue.
// change color of neighbor cells to new color if they are of initial color before processing and will be colored of new color
                if (row >= 0 && row < m && col >= 0 && col < n && image[row][col] == color) {
                    image[row][col] = newColor;
                    queue.add(new int[]{row,col});
                }
            }   
        }
        
        return image;     
    }
}