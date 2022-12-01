import java.util.LinkedList;
import java.util.Queue;

/**
 * TC - O(m * n) - m - image row count, n - image column count
 * SC - O(m * n) - m - image row count, n - image column count
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        int row = image.length;
        int col = image[0].length;

        int oldColor = image[sr][sc];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc});

        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}}; // U D L R

        image[sr][sc] = color;

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();

            for(int[] dir: dirs) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];

                if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && image[newRow][newCol] == oldColor) {
                    image[newRow][newCol] = color;
                    queue.add(new int[] {newRow, newCol});
                }
            }
        }

        return image;
    }
}
