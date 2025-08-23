// Time Complexity : O(m * n), m - rows, n - columns
// Space Complexity : O()
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. From the given row, col index, do DFS
// 2. In DFS, if neighbor cell is not the original color, return
// 3. Else, explore all the 4 neighbors

public class FloodFill {
    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return dfs(image, sr, sc, image[sr][sc], color);
    }

    private static int[][] dfs(int[][] image, int sr, int sc, int oldColor, int color) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || image[sr][sc] != oldColor || oldColor == color) {
            return image;
        }
        image[sr][sc] = color;

        // right
        dfs(image, sr, sc+1, oldColor, color);
        // left
        dfs(image, sr, sc-1, oldColor, color);
        // up
        dfs(image, sr-1, sc, oldColor, color);
        // down
        dfs(image, sr+1, sc, oldColor, color);
        return image;
    }

    private static void print(int[][] mat) {
        System.out.println("Printing matrix...");
        for(int[] row : mat) {
            for(int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,1}, {1,1,0}, {1,0,1}};
        print(mat);
        int[][] res = floodFill(mat, 1, 1, 2);
        print(res);
    }
}
