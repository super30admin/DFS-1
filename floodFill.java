//time O(mn)
//space O(mn)

class Solution {
    int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor = image[sr][sc];
        if(orgColor == color) return image;
        return dfs(image, sr, sc, color, orgColor);
    }
    
    private int[][] dfs(int[][] image, int r, int c, int color, int orgColor) {
        //logic
        image[r][c] = color;
        for(int[] dir: dirs) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            if(nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && image[nr][nc] != color && image[nr][nc] == orgColor)
            dfs(image, nr, nc, color, orgColor);
        }
        return image;
    }
}
