// Time Complexity : O(m*n) since we may have to search the entire matrix
// Space Complexity :O(h) where h is the height of the stack O(m*n) in worst case if we have to fill entire matrix
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

/*
we can fill in df,bfs way since the level doesnt matter,
the only imp thing is if the cell value is the previous color value change the color else 
if cell value is not = initialColor or out of boundary.. then return (base case)

otherwise current cell has previous color, first change it and recursively do helper() on neighbouring elements 
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;

        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public void helper(int[][] image, int row, int col, int newColor, int initialColor) {

        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != initialColor) {
            return;
        }

        image[row][col] = newColor;

        for (int dir[] : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            helper(image, r, c, newColor, initialColor);
        }

    }
}