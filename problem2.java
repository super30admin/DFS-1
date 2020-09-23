public class problem2 {

}

// time:O{n}
// space:O(n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image == null || image[0].length == 0 || image.length == 0 || image[sr][sc] == newColor)
            return image;

        dfs(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        image[i][j] = newColor;

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == oldColor)
                dfs(image, r, c, oldColor, newColor);
        }
    }
}