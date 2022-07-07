// TIme Complexity:O(m*n)
// Space Complexity:O(m*n)

public class FloodFill {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        dfs(image, sr, sc, newColor, color, m, n);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int newColor, int color, int m, int n){
        //base
        if(r < 0 || c<0 || r == m || c == n || image[r][c] != color) return;
        //logic
        image[r][c] = newColor;
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(image, nr, nc, newColor, color, m, n);
        }
    }
}
