// Time Complexity : O(N*M), N and M is the dimension of image
// Space Complexity : O(N*M), N and M is the dimension of image
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We need color to all the neighbours of the source(sr,sc) with new color in the image. We can perform
// DFS on the source and add its neighbors to the queue and change the neighbor color to the given color. Then
// we can call DFS recursively on the neighbor of the source and so on. We will need to maintain a boolean matrix to keep
// check of whether that particular image cell is already colored by new color or not.
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) return image;

        int r = image.length;
        int c = image[0].length;
        boolean isVisited[][] = new boolean[r][c];

        floodFill(image, image[sr][sc], sr, sc, newColor, isVisited);
        return image;
    }


    public void floodFill(int[][] image, int value, int sr, int sc, int newColor, boolean[][] isVisited) {
        int r = image.length;
        int c = image[0].length;

        if (sr < 0 || sr >= r) return;
        if (sc < 0 || sc >= c) return;

        if (image[sr][sc] != value) return;
        if (isVisited[sr][sc]) return;


        image[sr][sc] = newColor;
        isVisited[sr][sc] = true;

        floodFill(image, value, sr, sc + 1, newColor, isVisited);
        floodFill(image, value, sr, sc - 1, newColor, isVisited);
        floodFill(image, value, sr - 1, sc, newColor, isVisited);
        floodFill(image, value, sr + 1, sc, newColor, isVisited);
    }
}
