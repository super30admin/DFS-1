/*
* The time complexity of this implementation is O(N)
* time complexity is O(N)*/
class ColorFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // If the starting pixel has the same color as the fill color,
        // no need to do anything
        if (image[sr][sc] == color) {
            return image;
        }

        // Get the original color of the starting pixel
        int originalColor = image[sr][sc];

        // Call the recursive helper method to perform the flood fill
        fill(image, sr, sc, originalColor, color);

        return image;
    }

    private void fill(int[][] image, int row, int col, int originalColor, int newColor) {
        // Base case: if the current pixel is out of bounds or has a color different
        // from the original color, return
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length
                || image[row][col] != originalColor) {
            return;
        }

        // Set the current pixel to the new color
        image[row][col] = newColor;

        // Recursively fill the neighboring pixels in all four directions
        fill(image, row - 1, col, originalColor, newColor); // up
        fill(image, row + 1, col, originalColor, newColor); // down
        fill(image, row, col - 1, originalColor, newColor); // left
        fill(image, row, col + 1, originalColor, newColor); // right
    }
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        ColorFill solution = new ColorFill();
        int[][] result = solution.floodFill(image, sr, sc, newColor);

        // Print out the updated image
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
