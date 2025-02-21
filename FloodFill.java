// Time complexity:- O(m * n)
// Space complexity:- O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach:
 * This problem is about filling a pixel in an image starting from a given pixel with a new color. 
 * I used BFS to explore all connected pixels with the original color and change their color to the target color. 
 * The BFS ensures that all neighboring pixels (up, down, left, right) are processed using a queue to track the pixels to be filled.
 */
// BFS Solution
 class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        
        // Store the original color of the starting pixel
        int originalColor = image[sr][sc]; 

        // If the original color is the same as the target color, no need to proceed
        if (originalColor == color) {
            return image;
        }

        // Use a queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc}); // Add the starting point to the queue

        // Start BFS
        while (!queue.isEmpty()) {
            // Get the current pixel position from the queue
            int[] current = queue.remove();

            int r = current[0];
            int c = current[1];

            // Change the color of the current pixel
            image[r][c] = color;

            // go all 4 neighboring cells (up, down, left, right)
            // Up: r-1, c
            if (r - 1 >= 0 && image[r - 1][c] == originalColor) {
                // Add the up cell to the queue
                queue.add(new int[]{r - 1, c}); 
            }
            // Down: r+1, c
            if (r + 1 < rows && image[r + 1][c] == originalColor) {
                // Add the down cell to the queue
                queue.add(new int[]{r + 1, c}); 
            }
            // Left: r, c-1
            if (c - 1 >= 0 && image[r][c - 1] == originalColor) {
                // Add the left cell to the queue
                queue.add(new int[]{r, c - 1}); 
            }
            // Right: r, c+1
            if (c + 1 < cols && image[r][c + 1] == originalColor) {
                 // Add the right cell to the queue
                queue.add(new int[]{r, c + 1});
            }
        }
        // Return the modified image
        return image; 
    }
}
//DFS Solution
// Time complexity:- O(m * n)
// Space complexity:- O(m * n)
// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach:
 * I used a recursive DFS function to explore all connected pixels with the original color and change them to the target 
 * color by checking each neighboring pixel (up, down, left, right). The DFS ensures that the entire connected region is 
 * filled by recursively visiting each valid neighboring pixel that matches the original color.
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rows = image.length;
        int cols = image[0].length;

        int originalColor = image[sr][sc]; 
        System.out.println("Original Color: "+originalColor);

        if(image[sr][sc] == color) {
            return image;
        }

        dfs(image,sr,sc, originalColor,color,rows,cols); 
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int originalColor, int color, int rows, int cols ) {
        
        //boundries checking
        if(sr < 0 || sc < 0 || sr >= rows || sc >= cols || image[sr][sc] != originalColor) {
            return;
        }

        image[sr][sc] = color;
        dfs(image, sr-1, sc, originalColor, color,rows,cols );
        dfs(image, sr+1, sc, originalColor, color,rows,cols );
        dfs(image, sr, sc-1, originalColor, color,rows,cols );
        dfs(image, sr, sc+1, originalColor, color,rows,cols );
    }
}