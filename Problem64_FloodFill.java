// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int val;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.val = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }
    public void dfs(int[][] image, int row, int col, int newColor) {
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != val || image[row][col] == newColor)
            return;
        if(row >= 0 && row <= image.length - 1 && col >= 0 && col <= image[0].length - 1 && image[row][col] == val) {
            image[row][col] = newColor;
            dfs(image, row + 1, col, newColor);
            dfs(image, row - 1, col, newColor);
            dfs(image, row, col + 1, newColor);
            dfs(image, row, col - 1, newColor);
        }
    }
}