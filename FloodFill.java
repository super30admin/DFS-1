// Time Complexity : O(n * m)
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0 || image[sr][sc] == newColor) return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int checkColor = image[sr][sc];
        image[sr][sc] = newColor;

        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        while (!queue.isEmpty()) {


            int[] pair = queue.poll();
            for (int[] d : dirs) {
                int r = d[0] + pair[0];
                int c = d[1] + pair[1];

                if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == checkColor) {
                    queue.add(new int[]{r, c});
                    image[r][c] = newColor;
                }
            }

        }
        return image;
    }

}
