/**
 * Time Complexity (TC): O(m * n) - m : rows, n: columns
 * Space Complexity (SC): O(m * n)
 */

class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor != color) {
            dfs(image, sr, sc, color, oldColor);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int oldColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }

        image[sr][sc] = color;

        for (int[] dirs : directions) {
            dfs(image, sr + dirs[0], sc + dirs[1], color, oldColor);
        }
    }
}
