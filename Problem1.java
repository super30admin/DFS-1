// Time Complexity : O(m * n)
// Space Complexity : O(2(min(m, n)))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// DFS recursive approach

class Solution {
    
    private int[][] directions = new int[][] {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if (image[sr][sc] != newColor) {
            flood(image, sr, sc, image[sr][sc], newColor);
        }
        
        return image;
    }
    
    private void flood(int[][] image, int row, int col, int scClr, int newClr) {
        
        // base and edge cases
        if (
            row < 0 || row >= image.length ||
            col < 0 || col >= image[0].length ||
            image[row][col] != scClr
        ) {
            return;
        }
        
        image[row][col] = newClr;
        
        for (int[] dir : directions) {
            
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            flood(image, newRow, newCol, scClr, newClr);
        }
    }
}