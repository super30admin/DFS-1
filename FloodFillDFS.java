// TC - O(M*N)
// SC - O(M*N)

public class FloodFillDFS {
    class Solution {

        private final int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int originalColor = image[sr][sc];
            if (originalColor == newColor) {
                return image;
            }

            dfs(image, sr, sc, originalColor, newColor);

            return image;
        }

        private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
            if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
                return;
            }

            if (image[row][col] != originalColor) {
                return;
            }

            image[row][col] = newColor;

            for (int[] dir : dirs) {
                int currRow = row + dir[0];
                int currCol = col + dir[1];
                dfs(image, currRow, currCol, originalColor, newColor);
            }
        }
    }
}
