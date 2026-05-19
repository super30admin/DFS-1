// Time Complexity : O(m*n)
// Space Complexity : O(m*n) recursion stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
    I keep track of the original color at position [sr,sc]. I start DFS from that position and visit neighbours one by one.
    If a neighbour has the same color as original color, I change it's color to the new color.
*/

public class Solution
{
    private int[][] dirs;
    private int rows;
    private int columns;

    public int[][] FloodFill(int[][] image, int sr, int sc, int color)
    {
        rows = image.Length;
        columns = image[0].Length;

        dirs = new int[][]
        {
            new int[] {0,1},
            new int[] {0,-1},
            new int[] {1,0},
            new int[] {-1,0},
        };

        DFS(image, sr, sc, color, image[sr][sc]);

        return image;
    }

    private void DFS(int[][] image, int i, int j, int color, int ogColor)
    {
        if (i < 0 || i >= rows || j < 0 || j >= columns || image[i][j] != ogColor || image[i][j] == color)
        {
            return;
        }

        image[i][j] = color;
        foreach (int[] dir in dirs)
        {
            DFS(image, i + dir[0], j + dir[1], color, ogColor);
        }
    }
}