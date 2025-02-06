import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 *
 * Approach:
 * Can be solved using either BFS or DFS
 * Check the given sr and sc and traverse to all its neighbors and eligible neighbor's neighbors converting to given color.
 */

public class FloodFill {

    // ------------------------------------------------------------ DFS Approach ------------------------------------------------------------
    int m, n;
    int[][] dirs;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        m = image.length;
        n = image[0].length;

        dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int oldColor) {
        image[sr][sc] = color;

        // logic
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                dfs(image, nr, nc, color, oldColor);
            }
        }
    }

    // ------------------------------------------------------------ BFS Approach ------------------------------------------------------------
    
    public int[][] floodFillBfs(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color)
            return image;
        m = image.length;
        n = image[0].length;

        dirs = new int[][] {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        bfs(image, sr, sc, color);

        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        int oldColor = image[sr][sc];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            image[sr][sc] = color;
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                    q.add(new int[] { nr, nc });
                    image[nr][nc] = color;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Your code here
        FloodFill obj = new FloodFill();
        int[][] image = {
            {1,1,0},
            {0,1,1},
            {1,1,1}
        };

        int sr = 2;
        int sc = 2;
        int color = 3;
        obj.floodFill(image, sr, sc, color);
        System.out.println(Arrays.deepToString(image));

        color = 4;
        obj.floodFillBfs(image, sr, sc, color);
        System.out.println(Arrays.deepToString(image));
    }
}
