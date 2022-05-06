import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    //BFS
    //    TC : O(n)
    //    Sc : O(n)

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) return image;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        if (image[sr][sc] == newColor) return image;
        int m = image.length;
        int n = image[0].length;

        Queue<Integer> raw = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int color = image[sr][sc];
        raw.add(sr);
        cols.add(sc);

        while (!raw.isEmpty()) {
            int r = raw.poll();
            int c = cols.poll();
            if (r >= 0 && r < m && c >= 0 && c < n && image[r][c] == color) {
                image[r][c] = newColor;
                for (int[] dir : dirs) {
                    raw.add(r + dir[0]);
                    cols.add(c + dir[1]);
                }
            }

        }
        return image;
    }

    //DFS
    //    TC : O(n)
    //    Sc : O(n)

    int m, n, color;
    int[][] dirs;

    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if (image == null) return image;

        dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        if (image[sr][sc] == newColor) return image;
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];

        helper(image, sr, sc, newColor);
        return image;
    }

    private void helper(int[][] image, int r, int c, int newColor) {
        //base case
        //logic
        if (r >= 0 && r < m && c >= 0 && c < n && image[r][c] == color) {
            image[r][c] = newColor;
            for (int[] dir : dirs) {
                helper(image, r + dir[0], c + dir[1], newColor);
            }
        }

    }
}
