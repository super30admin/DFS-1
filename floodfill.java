class Solution {
    int[][] dirs;
    int cc;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null||image[sr][sc]==color) return image;
         int m= image.length;
        int n= image[0].length;
      dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
      cc=image[sr][sc];
       // image[sr][sc]=color;
        dfs(image,sr,sc,m,n,cc,color);
        return image;
}
private void dfs(int[][] image, int sr, int sc,int m,int n, int cc, int color){
     if(sr<0 || sc <0 || sr >m-1 || sc >n-1 || image[sr][sc]==color) return;
     if(image[sr][sc]==cc){
     image[sr][sc]=color;
     for(int[]dir:dirs){
         int nr= sr+dir[0];
         int nc= sc+dir[1];
         dfs(image,nr,nc,m,n,cc,color);
     }}
}
}