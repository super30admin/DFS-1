import java.util.LinkedList;
import java.util.Queue;

// TC - O(M*N)
// SC - O(M*N)

public class FloodFillBFS {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int originalColor = image[sr][sc];
            if (originalColor == newColor) {
                return image;
            }

            int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
            Queue<Integer> queue = new LinkedList<>();
            image[sr][sc] = newColor;
            queue.add(sr);
            queue.add(sc);

            while (!queue.isEmpty()) {
                int row = queue.poll();
                int col = queue.poll();
                for (int[] dir : dirs) {
                    int currRow = row + dir[0];
                    int currCol = col + dir[1];
                    if (currRow >= 0 && currRow < image.length && currCol >= 0 && currCol < image[0].length) {
                        if (image[currRow][currCol] == originalColor) {
                            image[currRow][currCol] = newColor;
                            queue.add(currRow);
                            queue.add(currCol);
                        }
                    }
                }
            }
            return image;
        }
    }
}
