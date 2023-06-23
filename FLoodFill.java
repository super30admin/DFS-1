// Time Complexity o(n*m) Space complexity o(n*m)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<Integer> q = new LinkedList<>();
        if (image == null)
            return image;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (image[sr][sc] == color)
            return image;
        int orig = image[sr][sc];
        q.add(sr);
        q.add(sc);
        image[sr][sc]=color;
        while (!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && image[nr][nc] == orig) {
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}
