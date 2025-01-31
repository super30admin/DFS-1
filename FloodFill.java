class FloodFill {
    int m,n;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color){
            return image;
        }

        m = image.length;
        n = image[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int oldColor){
        //base
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc]!=oldColor){
            return;
        }

        if(image[sr][sc] == oldColor){
            image[sr][sc] = color;
        }

        //logic
        for(int[] dir: dirs){
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;

            if(nr>=0 && nr<m && nc>=0 && nc<n){
                dfs(image, nr, nc, color, oldColor);
            }

        }

    }
}
