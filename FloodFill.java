/**
 * Time complexity - O(m x n) where m = number of rows and n = number of columns
 * Space complexity - O(1)
 * 
 */
public class FloodFill {

    int startPix = -1;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image == null || sr < 0 || sc < 0)
            return null;

        startPix = image[sr][sc];
        helper(image, sr, sc, newColor, startPix);
        return image;
    }

    public void helper(int[][] image, int sr, int sc, int newColor, int startPix) {

        if (sr > image.length - 1 || sr < 0)
            return;
        if (sc > image[0].length - 1 || sc < 0)
            return;
        if (image[sr][sc] == newColor)
            return;
        if (image[sr][sc] != startPix)
            return;

        if (image[sr][sc] == startPix)
            image[sr][sc] = newColor;

        // up
        helper(image, sr - 1, sc, newColor, startPix);
        // left
        helper(image, sr, sc - 1, newColor, startPix);
        // right
        helper(image, sr, sc + 1, newColor, startPix);
        // down
        helper(image, sr + 1, sc, newColor, startPix);
    }

}