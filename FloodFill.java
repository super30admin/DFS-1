package com.ds.rani.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 *
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 *
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */

//Approach: In both DFS and BFS,viit the given cell and change its color and then visit its 4 neigbours
//Time complexity:o(rows*cols)
//Space complexity:o(rows*cols)
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //DFS approach
        int oldColor = image[sr][sc];

        //edge case
        if (image == null || image.length == 0 || oldColor == newColor)
            return image;
        //dfs( image, sr, sc, newColor, oldColor );
        BFS( image, sr, sc, newColor, oldColor );
        return image;

    }

    int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**********************DFS *********************************************************/
    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        //base case
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor)
            return;

        //logic
        //change the old color to newcolor for current cell and visit its neigbours using dirs array
        image[sr][sc] = newColor;
        for (int dir[] : dirs) {
            int row = sr + dir[0];
            int col = sc + dir[1];
            dfs( image, row, col, newColor, oldColor );
        }
    }

    /**********************BFS *********************************************************/
    private void BFS(int[][] image, int sr, int sc, int newColor, int oldColor) {
        Queue<int[]> q = new LinkedList<>();

        //add sr,sc cell in queue to start visiting its neigbours and change its color to new color
        q.add( new int[]{sr, sc} );
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {

            int[] currCell = q.remove();

            //visit 4 neighbours of current cell
            for (int[] dir : dirs) {
                int row = currCell[0] + dir[0];
                int col = currCell[1] + dir[1];

                if (row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row][col] == oldColor) {
                    //change the color of that neigbour and add it in queue to vit its neigbours
                    image[row][col] = newColor;
                    q.add( new int[]{row, col} );
                }

            }
        }
    }
}
