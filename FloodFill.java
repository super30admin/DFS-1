/**To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally 
* to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally 
* to those pixels (also with the same color as the starting pixel), and so on. 
* Replace the color of all of the aforementioned pixels with the newColor.
* TC O(N) and SC O(N)
*/
class Solution {
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length ==0)
            return image;
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length ||
            image[row][col] == newColor || image[row][col] != color ) 
        {
            return;
        }
        image[row][col] = newColor;
        int [][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (int i = 0; i< dirs.length; i++)
        {
            int r = row + dirs[i][0];
            int c = col + dirs[i][1];
            dfs(image, r, c, newColor);
        }
    }
}
