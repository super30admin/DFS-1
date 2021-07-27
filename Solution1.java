// Time complexity: O(m*n), where m*n is the size of image.
// Space complexity: O(m*n)

class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        dfs(image, sr, sc, image[sr][sc], newColor); 
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        // base case
        if(r < 0 || r >= image.length || c < 0 || c >= image[r].length || image[r][c] != color)
            return;
        //change color
        image[r][c] = newColor;
        // move to 4 directions
        dfs(image, r-1, c, color, newColor); 
        dfs(image, r, c-1, color, newColor);
        dfs(image, r+1, c, color, newColor);
        dfs(image, r, c+1, color, newColor);
    }
}
