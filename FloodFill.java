import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    // TC O(M*N)
    // SC O(M*N)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == color) {
                    q.add(new int[] { nr, nc });
                    image[nr][nc] = newColor;
                }
            }
        }
        return image;
    }
}
