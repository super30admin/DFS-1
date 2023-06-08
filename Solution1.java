class Solution1 {
    boolean[][] isVisited;
    int old;
    int m;
    int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        old = image[sr][sc];
        m = image.length;
        n = image[0].length;
        isVisited = new boolean[m][n];
        dfs(image, sr, sc, color);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int color) {
        isVisited[i][j] = true;
        image[i][j] = color;
        int[] x = new int[]{0, 1, 0, -1};
        int[] y = new int[]{1, 0, -1, 0};
        for(int k = 0; k < 4; k++) {
            int ni = i + x[k];
            int nj = j + y[k];
            if( ni >= 0 && nj >= 0 && ni < m && nj < n && image[ni][nj] == old && !isVisited[ni][nj]) {
                dfs(image, ni, nj, color);
            }
        }
    }
}