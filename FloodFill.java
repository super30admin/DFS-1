import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode: https://leetcode.com/problems/flood-fill/
 *
 * Approach:
 * This class provides two solutions to the Flood Fill problem: one using Depth-First Search (DFS) and one using Breadth-First Search (BFS).
 *
 * 1. floodFill (DFS):
 *    - Recursively traverses the image grid from the starting cell (sr, sc), visiting all 4-directionally connected cells with the same initial color.
 *    - Changes their color to the new color, stopping if a cell is out of bounds, already colored, or does not match the initial color.
 *
 * 2. floodFillBFS (BFS):
 *    - Uses a queue to iteratively traverse the image grid from the starting cell (sr, sc).
 *    - All 4-directionally connected cells with the same initial color are enqueued and colored layer by layer.
 *
 * Time Complexity (both methods): O(m * n) in the worst case, where m is the number of rows and n is the number of columns. Every cell may be visited once.
 * Space Complexity:
 *   - DFS: O(m * n) in the worst case due to the recursion stack (if the entire image is filled).
 *   - BFS: O(m * n) in the worst case due to the queue (if the entire image is filled).
 */
public class FloodFill {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        if (initialColor == color) return image;

        dfs(image, sr, sc, color, initialColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int initialColor) {
        //base
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length
                || (image[sr][sc] != initialColor))
            return;

        //logic
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            int cr = sr + dir[0];
            int cc = sc + dir[1];
            dfs(image, cr, cc, color, initialColor);
        }
    }

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        int rLength = image.length;
        int cLength = image[0].length;
        int initialColor = image[sr][sc];
        if (initialColor == color) return image;
        Queue<int[]> queue = new LinkedList<>();
        image[sr][sc] = color;
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            image[current[0]][current[1]] = color;
            for (int[] dir : dirs) {
                int cr = current[0] + dir[0];
                int cc = current[1] + dir[1];
                if (cr >= 0 && cc >= 0 && cc < cLength && cr < rLength && image[cr][cc] == initialColor) {
                    queue.add(new int[]{cr, cc});
                }
            }
        }
        return image;
    }

}
