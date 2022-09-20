class Solution {
    //tc-o(m*n)
    //sc-o(m*n)
      int[][]dirs;
      int m;
      int n;
      int color;
     public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        if(image == null || image[sr][sc] == newcolor) return image;
        m = image.length;
        n = image[0].length;
        
        color = image[sr][sc];
        dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        dfs(image,sr,sc,newcolor);
      
        return image;
        
    }
    private void dfs(int[][]image,int sr,int sc,int newcolor)
    {
        //basecase
        if(sr<0 || sc<0 || sr==m || sc==n || image[sr][sc] != color) return;
        image[sr][sc] = newcolor;
        
        //logic
        for(int[] dir : dirs)
        {
            int nr = dir[0]+sr;
            int nc = dir[1]+sc;
            dfs(image,nr,nc,newcolor);
        }
    }
}