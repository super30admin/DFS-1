
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

import java.util.*;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        if (image == null || image.length == 0) return image;

        Queue<int[]> q = new LinkedList<>();
        int currentcolor = image[sr][sc];
        q.add(new int[]{sr, sc});
        image[sr][sc] = newColor;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int i = dir[0] + curr[0];
                int j = dir[1] + curr[1];
                if (i >= 0 && i < image.length && j >= 0 && j < image[0].length && image[i][j] == currentcolor) {
                    q.add(new int[]{i, j});
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        FloodFill sol = new FloodFill();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = sol.floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
