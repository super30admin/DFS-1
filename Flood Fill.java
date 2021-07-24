class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image[sr][sc] == newColor) return image;

        int rows = image.length;
        int cols = image[0].length;
        int src = image[sr][sc];

        dfs(image,sr,sc,src,rows,cols,newColor);

        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int src , int rows , int cols, int newColor)
    {
        if(sr<0 || sr>=rows || sc<0 || sc>=cols) return;
        if(image[sr][sc] != src) return;

        image[sr][sc] = newColor;

        dfs(image,sr-1,sc,src,rows,cols,newColor);
        dfs(image,sr+1,sc,src,rows,cols,newColor);
        dfs(image,sr,sc-1,src,rows,cols,newColor);
        dfs(image,sr,sc+1,src,rows,cols,newColor);

    }
}
