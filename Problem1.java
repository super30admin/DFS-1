// Time Complexity : O (m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using bfs approach to change the color to immediate neighbors using a queue.
 */
class BFSSolution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origCol = image[sr][sc];
        if (origCol == color) return image;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == origCol) {
                    image[nr][nc] = color;
                    q.offer(new int[]{nr, nc});
                }
            }

        }

        return image;
    }
}

/**
 * Using dfs approach to change the color of the connected entries
 */
class DFSSolution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color)
            return image;

        int origCol = image[sr][sc];
        dfs(image, sr, sc, color, origCol);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int origColor) {
        //base
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || image[sr][sc] != origColor) return;

        image[sr][sc] = color;

        //logic
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color, origColor);
        }
    }
}