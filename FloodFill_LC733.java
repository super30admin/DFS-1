// Time Complexity: O(N), where N is the number of pixels in the image. We might process every pixel.
// Space Complexity : O(N), the size of the implicit call stack when calling dfs.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class FloodFill_LC733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int colorAtSP = image[sr][sc];
        
        if (color != colorAtSP) 
            dfs_approach(image, sr, sc, color, colorAtSP);

        return image;
    }

    private int[][] dfs_approach(int[][] image, int sr, int sc, int color, int colorAtSP) {
        
        if (image[sr][sc] == colorAtSP) {
            image[sr][sc] = color;
            
            if (sr >= 1) dfs_approach(image, sr - 1, sc, color, colorAtSP);

            if (sc >= 1) dfs_approach(image, sr, sc - 1, color, colorAtSP);

            if (sr + 1 < image.length) dfs_approach(image, sr + 1, sc, color, colorAtSP);

            if (sc + 1 < image[0].length) dfs_approach(image, sr, sc + 1, color, colorAtSP);
        }

        return image;
    }

}