import java.util.*;

class Solution {
    /*
        TC - O(m * n)
        SC - O(m * n)
        This solution uses BFS to recolor all connected pixels that have the same original color as the starting pixel.
        It starts from (sr, sc) given in the input, saves its original color (oldColor), changes it to the new color, and adds it to the queue. 
        Then, while processing the queue, it checks the four neighboring cells. If a neighbor has the oldColor, 
        it is recolored, added to the queue, and processed later. This continues until all connected pixels of the original 
        color have been recolored.
    */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        if (image[sr][sc] == color) return image;
        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        int oldColor = image[sr][sc];
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int cr = q.poll();
            int cc = q.poll();
            for (int[] dir : dirs) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldColor) {
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}