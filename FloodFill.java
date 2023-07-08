public class FloodFill {

    private static final int[][] Dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // Up, Down, Left, Right

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Check if the starting pixel already has the new color
        if (image[sr][sc] == newColor) {
            return image;
        }

        // Get the original color of the starting pixel
        int originalColor = image[sr][sc];

        // Recursive DFS function to perform flood fill
        dfs(image, sr, sc, originalColor, newColor);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        // Change the color of the current pixel
        image[row][col] = newColor;

        // Traverse the neighboring pixels
        for (int[] dir : Dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check if the neighboring pixel is within bounds and has the original color
            if (newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length
                    && image[newRow][newCol] == originalColor) {
                dfs(image, newRow, newCol, originalColor, newColor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        FloodFill floodFill = new FloodFill();
        int[][] result = floodFill.floodFill(image, sr, sc, newColor);

        // Print the result
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}