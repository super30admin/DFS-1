class FloodFill {
    
    // Time Complexity: O(n)    (where n -> no. of pixels in the array)
    // Space Complexity: O(n)
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Edge Case Checking
        if(image == null || image.length == 0 || image[0].length == 0)
            return image;
        
        // Checking if the starting pixel has the same color as the newColor
        if(image[sr][sc] == newColor)
            return image;
        
        // Perform DFS
        dfs(image, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int oldColor, int newColor){
        // Checking boundary conditions and if the pixel color matches the old color
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor)
            return;
        
        // Assigning the new pixel color
        image[row][col] = newColor;
        
        // Traversing in all four directions
        dfs(image, row-1, col, oldColor, newColor);
        dfs(image, row+1, col, oldColor, newColor);
        dfs(image, row, col-1, oldColor, newColor);
        dfs(image, row, col+1, oldColor, newColor);
        
        return;
    }
}