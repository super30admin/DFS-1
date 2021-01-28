// Time Complexity : O(m*n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : YES
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0)
            return image;

        boolean visited[][] = new boolean[image.length][image[0].length];
        helper(image, visited, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void helper(int[][] image, boolean[][] visited, int i, int j, int originalColor, int newColor) {
        if (i >= image.length || j >= image[0].length || i < 0 || j < 0)
            return;

        if (image[i][j] == originalColor && visited[i][j] == false) {
            image[i][j] = newColor;
            visited[i][j] = true;
            for (int dir[] : new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }) {
                int x = i + dir[0];
                int y = j + dir[1];
                helper(image, visited, x, y, originalColor, newColor);
            }

        }
    }

}
