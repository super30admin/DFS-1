import java.util.*;

//Time Complexity :O(NM)
//Space COmplexity: O(NM)
//LeetCode : Yes
public class FloodFIll {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image == null || image.length == 0) {
                return image;
            }
            int [][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int color = image[sr][sc];
            int m = image.length;
            int n = image[0].length;
            //if the given cell is already of new color then do nothing..as all connected cells of same color are already new color no point going over the image.
            if (image[sr][sc] == newColor) {
                return image;
            }
            Queue<int []> q = new LinkedList<>();
            //add the given cell into queue and change the color to new color
            q.add(new int[] {sr, sc});
            image[sr][sc] = newColor;

            while (!q.isEmpty()) {
                int size = q.size();
                int index = 0;
                while (index < size) {
                    int[] curr = q.poll();
                    for (int[] d : dir) {
                        int nr = curr[0] + d[0];
                        int nc = curr[1] + d[1];
                        if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color) {
                            image[nr][nc] = newColor;
                            q.add(new int[] {nr, nc});
                        }
                    }
                    index++;
                }
            }
            return image;
        }
    }
}
