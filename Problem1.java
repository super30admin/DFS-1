package DFS-1;

public class Problem1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = image.length;
        int n = image[0].length;
        Queue<Integer> q = new LinkedList<>();
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        q.add(sr);
        q.add(sc);
        while (!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    q.add(nr);
                    q.add(nc);
                }
            }

        }
        return image;
    }
}
