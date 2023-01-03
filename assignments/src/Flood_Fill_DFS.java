public class Flood_Fill_DFS {

    // Approach: DFS from the given node to every other node in the matrix
    // Time: O(n)
    // Space: O(n)
    int l,b;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        l = image.length;
        b = image[0].length;
        int originalColor = image[sr][sc];
        if (image[sr][sc] != color) fillColor(image, sr, sc, color, originalColor);
        return image;
    }

    void fillColor (int[][] image, int r, int c, int newColor, int color) {
        if (image[r][c] == color) {
            image[r][c] = newColor;

            if (r < l-1) fillColor(image, r+1, c, newColor, color);
            if (c < b-1) fillColor(image, r, c+1, newColor, color);
            if (r > 0) fillColor(image, r-1, c, newColor, color);
            if (c > 0) fillColor(image, r, c-1, newColor, color);
        }
    }
}