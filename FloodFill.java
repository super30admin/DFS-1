// 733.

//dfs because explore a particular neighbour first and change colour if needed
//time - O(m * n)
//space - O(m * n) - not sure
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge
        if(image == null || image.length == 0 || image[0].length == 0)
        {
            return new int[0][0];
        }
        
        //if the pixel already has the new colour return
        if(image[sr][sc] == newColor)
        {
            return image;
        }
        
        dfs(image, sr, sc, newColor);
        
        return image;
    }
    
    //time - O(m * n) - explores the full image
    //space - call stack - not sure but could be O(m * n)
    private void dfs(int[][] image, int sr, int sc, int newColor) {
        //store the old colour at the pixel and change it to new colour
        //explore neighbours and change colour if neighbour colour is old colour
        int m = image.length;
        int n = image[0].length;
        
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] direction : dirs)
        {
            int row = sr + direction[0];
            int col = sc + direction[1];
            if(row >= 0 && row < m && col >= 0 && col < n)
            {
                if(image[row][col] == oldColor)
                {
                    dfs(image, row, col, newColor);
                }
            }
        }
        
        return;
    }
}
