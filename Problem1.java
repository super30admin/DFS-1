// Time Complexity : O(m*n)
// Space Complexity : O(m*n) ~ recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
First, we check if the starting pixel already has the target color. If so, no changes are needed and we return the image immediately to avoid unnecessary DFS calls.
We use Depth-First Search (DFS) starting from the given pixel (sr, sc). For each cell, we verify boundary conditions and ensure the current pixel matches the original color before repainting it.
After repainting the current pixel, we recursively explore its four neighboring cells (up, down, left, right) using a direction array, ensuring all connected pixels with the original color are updated.
*/


public class Problem1 {
    int[][] dirs = {{0,1},{0,-1},{1,0}, {-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) {
            return image;
        }

        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int originalColor) {
        if(row < 0 || col < 0 || row >= image.length || col >= image[row].length || image[row][col] != originalColor) {
            return;
        }

        image[row][col] = color;
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(image, nr, nc, color, originalColor);
        }
    }
}
