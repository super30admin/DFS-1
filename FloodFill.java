/** 
 *  Time Complexity: O(m * n) where m is the number of rows in the image and n is the number of cols in the image
 *  Space Complexity: O(m * n) where m is the number of rows in the image and n is the number of cols in the image
 *  LeetCode: Y(https://leetcode.com/problems/flood-fill/)
 *  Approach:
        Do a DFS from image[sr][sc] looking into neighboring nodes
        Do not paint a pixel if it is already colored in newColor
        Do not paint a pixel if its color is not the same as source pixel's original color
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        // Perform dfs from image[sr][sc]
        dfs(image, sr, sc, image[sr][sc], newColor);

        return image;
    }
    
    /* Helper function to perform DFS */
    private void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        // return if a pixel position is invalid or pixel color is not the same as source pixel's original color or pixel is already painted
        if(!isMatrixPositionValid(row, col, image.length, image[0].length) || image[row][col] != oldColor || image[row][col] == newColor) {
            return;
        }
       
        // paint the cuurent pixel with newColor
        image[row][col] = newColor;
        
        // dirs array to look in the 4 neighboring pixels
        int[] dirs = {-1, 0, 1, 0, -1};
        
        // Look in all 4 directions
        for(int i = 0 ; i < 4 ; i++) {
            // get row number of neighboring pixel
            int neighborRow = row + dirs[i];

            // get col number of neighboring pixel
            int neighborCol = col + dirs[i + 1];
            
            // Explore neighboring pixel with DFS
            dfs(image, neighborRow, neighborCol, oldColor, newColor);
        }
    }
    
    /* Helper function to check if the current pixel is within the dimensions of the matrix */
    private boolean isMatrixPositionValid(int row, int col, int totalRows, int totalCols) {
        return (row >= 0 && col >= 0 && row < totalRows && col < totalCols);
    }
}
