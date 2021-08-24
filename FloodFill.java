//https://leetcode.com/problems/flood-fill/
/*
Time: O(N) where N is the number of pixels in the image
Space: O(N) - size of the runtime stack during recursion
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
//Idea: Do a DFS in all 4 directions from source 
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;

        fill(image, sr, sc, image[sr][sc], newColor);
        return image;

    }

    public void fill(int[][] image, int i, int j, int oldColor, int newColor) {
        // boundary conditions
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != oldColor)
            return;

        image[i][j] = newColor; // assign to initial pixel

        // traverse all neighbours
        fill(image, i + 1, j, oldColor, newColor);
        fill(image, i - 1, j, oldColor, newColor);
        fill(image, i, j + 1, oldColor, newColor);
        fill(image, i, j - 1, oldColor, newColor);
    }

}
