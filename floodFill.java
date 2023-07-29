// Time Complexity : O(m*n), where m is the number of rows and n is the number of columns
// Space Complexity : O(m*n), where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Start with the source, and store the starting color.
 * 2. For each pixel, check all the 4 directions and fill the image with the new color.
 * 3. Return the image.
 */

class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        int startingPixel = image[sr][sc];
        fillImage(image, sr, sc, color, visited, startingPixel);
        return image;
    }

    private void fillImage(int[][] image, int sr, int sc, int color, boolean[][] visited, int startingPixel){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc] || image[sr][sc] != startingPixel){
            return;
        }

        image[sr][sc] = color;
        visited[sr][sc] = true;
        for(int[] dir : dirs){
            int nrow = sr + dir[0];
            int ncol = sc + dir[1];
            fillImage(image, nrow, ncol, color, visited, startingPixel);
        }
    }
}