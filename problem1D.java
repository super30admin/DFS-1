class floodFill1{
    int m,n, color;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        color = image[sr][sc];

        dfs(image,sr,sc,newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor){

        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color){
            return;
        }
        image[sr][sc] = newColor;
        for(int[] dir : dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c, newColor);
        }
    }
}

// time complexity - > O(m*n)
// space complexity - > O(m*n)