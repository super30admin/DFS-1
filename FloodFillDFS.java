/**
Time Complexity : Exponential
Space Complexity : O(D), D = depth of the recursive stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    int rows;
    int cols;
    int originalColor;
    int dirs[][] = new int[][]{{1,0}, {-1,0,}, {0, -1}, {0,1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        
        if(image == null || image.length == 0)
            return image;
        
        this.rows = image.length;
        this.cols = image[0].length;
        this.originalColor = image[sr][sc];
        dfs(image, sr, sc, newColor);
        
        return image;
        
        
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor)
    {
        
        boolean isValid = sr >= 0 && sr < rows && sc >=0 && sc <cols && image[sr][sc] == originalColor;
        
        if(!isValid)
            return;
        
        if(image[sr][sc] == newColor)
            return;
        
        image[sr][sc] = newColor;
            
        for(int dir[]: dirs)
        {
            int row = sr + dir[0];
            int col = sc + dir[1];
            dfs(image, row, col, newColor);
        }

    }
}