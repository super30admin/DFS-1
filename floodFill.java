class Solution {
    //Time complexity: O(mn)
    //Space complexity: O(mn)
    int[][] dirs=new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
    int pcolor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        pcolor=image[sr][sc];
        if(pcolor==color)
            return image;
        dfs(image,m,n,sr,sc,color);
        return image;
    }
    private void dfs(int[][] image,int m,int n,int sr,int sc,int newcolor){
        if(sr<0 || sc<0 || sr==m || sc==n || image[sr][sc]!=pcolor)
            return;
        image[sr][sc]=newcolor;
        for(int[] dir:dirs){
            int nr=sr+dir[0];
            int nc=sc+dir[1];
            dfs(image,m,n,nr,nc,newcolor);
        }
    }
}