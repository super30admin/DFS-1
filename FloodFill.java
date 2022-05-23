// O(n) time, n number of pixels
// O(n) space, size of stack 

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor) dfs(image, sr, sc, currColor, newColor);
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int currColor, int newColor){
        if (image[r][c] == currColor){ // only if current pixel's colour is same as starting pixel's initial colour
            image[r][c] = newColor; // update colour
            // check neighbouring pixels, given boundaries
            if (r >= 1) dfs(image, r-1, c, currColor, newColor);
            if (c >= 1) dfs(image, r, c-1, currColor, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, currColor, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, currColor, newColor);
        }
    }
}