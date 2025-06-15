class Solution {
    //BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        int initColor = image[sr][sc];

        if (initColor == color)
            return image;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int cr = q.poll();
            int cc = q.poll();

            for (int[] dir : dirs) {
                int nr = dir[0] + cr;
                int nc = dir[1] + cc;
                //bounds check
                if (nr < n && nr >= 0 && nc < m && nc >= 0 && image[nr][nc] == initColor) {
                    image[nr][nc] = color;
                    q.add(nr);
                    q.add(nc);
                }
                //update the color and add in the queue
            }

        }

        return image;

    }

}