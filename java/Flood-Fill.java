// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
DFS approach. If the starting pixel which mentioned is of a color then change it ot new color and check its 4-directionally neighbouring pixels and change from color to newColor
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) return null;
        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, newColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int color) {

        //base
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        //logic
        image[sr][sc] = newColor;

        dfs(image, sr - 1, sc, newColor, color);

        dfs(image, sr, sc - 1, newColor, color);

        dfs(image, sr + 1, sc, newColor, color);

        dfs(image, sr, sc + 1, newColor, color);

    }
}