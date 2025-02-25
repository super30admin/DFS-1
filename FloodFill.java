//DFS
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null)
        return image;
        int m= image.length;
        int n=image[0].length;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int orgcol = image[sr][sc];
        if(orgcol==color)
        return image;
         dfs(image,sr,sc,orgcol,color,dirs);
         return image;
    }
    private void dfs(int[][] image, int sr, int sc, int orgcol, int color,int[][] dirs)
    {   
            int m= image.length;
            int n=image[0].length;
            if(sr<0 || sc<0 || sr>=m || sc>=n || image[sr][sc]!=orgcol)
            return;
            image[sr][sc]=color;
            for(int[] dir: dirs)
            {
                int nr =sr+dir[0];
                int nc = sc+dir[1];
                dfs(image,nr,nc,orgcol,color,dirs);
            }
    }
}

//tc: O(m×n)
//sc: O(m×n)