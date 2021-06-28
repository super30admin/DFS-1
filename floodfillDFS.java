package DFS1;

/*
DFS
Time Complexity: O(m * n)
Space Complexity: O(m * n) */

public class floodfillDFS {
	int color;
    int[][] dirs;
    int m;
    int n;
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        //Null Case
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];

        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int newColor) {
        //Base
        if(r < 0 || c < 0 || r == m || c == n || image[r][c] != color) return;
        //Logic
        image[r][c] = newColor;
        for(int[] dir: dirs) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(image, nr, nc, newColor);
        }
    }

}
