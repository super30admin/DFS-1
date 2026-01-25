import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

/*
LeetCode 733. Flood Fill
*/
public class FloodFill {

    private int[][] dirs;
    private int m, n;

    /*
     APPROACH 1: BFS (Queue)
     Idea:
     - Start from (sr, sc), recolor it, push it into a queue.
     - Pop pixels one-by-one, expand to 4 neighbors.
     - If a neighbor has oldColor, recolor it and push it.

     Time Complexity: O(m * n)
       - each cell is processed at most once

     Space Complexity: O(m * n) worst-case
       - queue may hold many cells (one large region)
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        m = image.length;
        n = image[0].length;

        int oldColor = image[sr][sc];
        if (oldColor == color) return image; // no change needed

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color; // mark visited by recoloring

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] d : dirs) {
                int newR = curr[0] + d[0];
                int newC = curr[1] + d[1];

                // boundary + only recolor cells that match oldColor
                if (newR >= 0 && newR < m && newC >= 0 && newC < n && image[newR][newC] == oldColor) {
                    image[newR][newC] = color;
                    q.add(new int[]{newR, newC});
                }
            }
        }

        return image;
    }

    /*
     APPROACH 2: DFS (Recursion)
     Idea:
     - Recolor current cell.
     - Recurse on 4 neighbors if they are in bounds and match oldColor.

     Time Complexity: O(m * n)
     Space Complexity: O(m * n) worst-case due to recursion stack (large region / deep traversal)
       - balanced regions typically smaller, but worst-case can be big
     */
    public int[][] floodFillUsingDFS(int[][] image, int sr, int sc, int color) {
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        m = image.length;
        n = image[0].length;

        int oldColor = image[sr][sc];
        if (oldColor == color) return image;

        dfs(image, sr, sc, color, oldColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int newColor, int oldColor) {
        // out of bounds OR not part of the region
        if (r < 0 || c < 0 || r >= m || c >= n || image[r][c] != oldColor) return;

        // recolor current pixel
        image[r][c] = newColor;

        // visit neighbors
        for (int[] d : dirs) {
            dfs(image, r + d[0], c + d[1], newColor, oldColor);
        }
    }

    // Simple main method to test (no assertions)
    public static void main(String[] args) {
        FloodFill solver = new FloodFill();

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1, sc = 1, color = 2;

        // Make copies because methods mutate the image
        int[][] imageForBFS = copy(image);
        int[][] imageForDFS = copy(image);

        System.out.println("Original image:");
        print(image);

        System.out.println("\nBFS Flood Fill result:");
        solver.floodFill(imageForBFS, sr, sc, color);
        print(imageForBFS);

        System.out.println("\nDFS Flood Fill result:");
        solver.floodFillUsingDFS(imageForDFS, sr, sc, color);
        print(imageForDFS);
    }

    private static int[][] copy(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            System.arraycopy(img[i], 0, res[i], 0, img[0].length);
        }
        return res;
    }

    private static void print(int[][] img) {
        for (int[] row : img) {
            System.out.println(Arrays.toString(row));
        }
    }
}
