// TC - O(m*n)
// Space - O(m*n)
// Leetcode passed - Yes


public class FloodFill {
    int [][] dirs;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }

        dirs = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0,1}};
        color = image[sr][sc];
        floodFillDFS(image, sr, sc, newColor);
        return image;
    }

    public void floodFillDFS(int [][] image, int sr, int sc, int newColor) {
        // base case
        // if indices are beyond the extremes, or the element is not equal to color, then will simply return
        if(sr < 0 || sr >= image.length || sc <0 || sc>= image[0].length || image[sr][sc] != color) {
            return;
        }

        // logic
        // chaging it to new color
        image[sr][sc] = newColor;
        for(int [] dir: dirs) {
            // moving in all 4 directions and doing recursive call
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            floodFillDFS(image, nr, nc, newColor);
        }
    }
}
