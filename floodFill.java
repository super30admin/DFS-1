class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;

        int color = image[sr][sc];
        performFloodFill(image, sr, sc, newColor, color);
        return image;
    }

    private void performFloodFill(int[][] image, int sr, int sc, int newColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
            return;

        image[sr][sc] = newColor;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int[] dir : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];
            performFloodFill(image, r, c, newColor, color);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = solution.floodFill(image, sr, sc, newColor);

        // Print ans = [[2,2,2],[2,2,0],[2,0,1]]
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
