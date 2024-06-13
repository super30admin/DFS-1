/***
 TC - O(m+n)
 SC - O(1)
 */
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color)
            return image;

        floodFill(image, sr, sc, color, image[sr][sc]);

        return image;
    }

    public void floodFill(int[][] image, int sr, int sc, int color, int start_pixel) {
        if(sr >=0 && sr < image.length && sc >=0 && sc < image[0].length && image[sr][sc] == start_pixel) {
            image[sr][sc] = color;
            floodFill(image, sr+1, sc, color, start_pixel);
            floodFill(image, sr-1, sc, color, start_pixel);
            floodFill(image, sr, sc+1, color, start_pixel);
            floodFill(image, sr, sc-1, color, start_pixel);
        }
    }
}