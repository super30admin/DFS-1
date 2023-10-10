public class FloodFill {
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int srcColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color)
            return image;
        srcColor = image[sr][sc];
        recurse(image, sr, sc, color);
        return image;
    }

    private void recurse(int[][] image, int row, int col, int color) {
        if (row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row][col] == srcColor) {
            image[row][col] = color;
        } else
            return;
        image[row][col] = color;
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            recurse(image, nr, nc, color);
        }

    }
}
