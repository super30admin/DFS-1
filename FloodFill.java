// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// DFS starting from the given element. Keep going in all directions
// till it's equal to the original color and not equal to the fill color

class FloodFill {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int originalColor) {
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] == color
                || image[row][col] != originalColor) {
            return;
        }

        image[row][col] = color;

        for (int[] dir : dirs) {
            dfs(image, row + dir[0], col + dir[1], color, originalColor);
        }
    }
}