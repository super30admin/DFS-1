// Approach: Traverse the given matrix using a DFS approach, starting from the given cell. Only update cells that have the same color as
// the initial color and do not already have the target color. Each cell has four possible neighbors.
// Time Complexity: O(m * n) where m - #rows, n - #cols
// Space Complexity: O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/flood-fill/description/

public class FloodFill {

    void floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, color, image[sr][sc]);
    }

    void fill(int[][] image, int r, int c, int color, int initial) {
        if (r < 0 || r == image.length || c < 0 || c == image[0].length) {
            return;
        }
        if (image[r][c] != initial || image[r][c] == color) {
            return;
        }
        image[r][c] = color;
        fill(image, r - 1, c, color, initial);
        fill(image, r, c + 1, color, initial);
        fill(image, r + 1, c, color, initial);
        fill(image, r, c - 1, color, initial);
    }

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        // Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
        // Output: [[2,2,2],[2,2,0],[2,0,1]]
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        int sr = 1, sc = 1, color = 2;
        ff.floodFill(image, sr, sc, color);

        System.out.println("Given image after flood filled:");
        for (int[] row: image) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + " ");
            }
            System.out.println();
        }
    }
}