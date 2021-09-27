class floodFills {

    // DFS TC: O(N) SC: O(N)
    int m, n;
    int color;
    int[][] dirs;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        if (image[sr][sc] == newColor)
            return image;
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor) {
        // base
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color)
            return;
        // logic
        image[sr][sc] = newColor;
        for (int[] dir : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c, newColor);
        }

    }

}

// //BFS TC: O(N) SC: O(N)
// public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
// int m = image.length; int n = image[0].length;
// if(image[sr][sc] == newColor) return image;
// Queue<Integer> row = new LinkedList<>();
// Queue<Integer> col = new LinkedList<>();
// int color = image[sr][sc];
// image[sr][sc] = newColor;
// row.add(sr); col.add(sc);
// int [][] dirs = new int [][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
// while(!row.isEmpty()){
// int cr = row.poll();
// int cc = col.poll();
// for(int [] dir: dirs){
// int r = cr + dir[0];
// int c = cc + dir[1];
// if(r >= 0 && c >= 0 && r < m && c < n && image[r][c] == color){
// image[r][c] = newColor;
// row.add(r); col.add(c);
// }
// }

// }
// return image;
// }