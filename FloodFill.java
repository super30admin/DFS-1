class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int start = image[sr][sc];
        if (image == null || image.length == 0)
            return image;
        int m = image.length;
        int n = image[0].length;

        color(image, sr, sc, m, n, color, new boolean[m][n], start);

        return image;
    }

    public void color(int[][] image, int sr, int sc, int m, int n, int color, boolean visited[][], int start) {
        if (sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc] != start || visited[sr][sc])
            return;
        image[sr][sc] = color;
        visited[sr][sc] = true;
        color(image, sr - 1, sc, m, n, color, visited, start);
        color(image, sr + 1, sc, m, n, color, visited, start);
        color(image, sr, sc - 1, m, n, color, visited, start);
        color(image, sr, sc + 1, m, n, color, visited, start);
    }
}