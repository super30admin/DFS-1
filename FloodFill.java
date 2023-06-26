public class FloodFill {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        if(image==null || image.length==0)
            return image;
        int origColor=image[sr][sc];
        if(origColor==color)
            return image;
        dfs(image,sr,sc,color,origColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int newColor, int origColor){
        if(r<0 || r==image.length || c<0 || c==image[0].length || image[r][c]!=origColor )
            return;
        image[r][c]=newColor;
        for(int[] dir : dirs){
            int nr=r + dir[0];
            int nc=c + dir[1];
            dfs(image,nr,nc,newColor,origColor);
        }
    }
}
