class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        int oldColor = image[sr][sc];
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] value = q.poll();
            for (int[] dir : dirs) {
                int nr = value[0] + dir[0];
                int nc = value[1] + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    q.add(new int[] { nr, nc });
                }
            }
        }

        return image;
    }
}