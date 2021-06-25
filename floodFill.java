//time and space complexity :O(m x n)
class Solution {
    int n;int m;int color;int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0||image[sr][sc]==newColor) return image;
        m=image.length;
        n=image[0].length;
        color=image[sr][sc]; 
        dirs=new int[][] {{0,1},{0,-1},{-1,0},{1,0}};
        dfs(image,sr,sc,newColor);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int newColor)
    {
        if(r<0||c<0||r==m||c==n||image[r][c]!=color) return;
        image[r][c]=newColor;//change the color of the given element
        for(int[] dir:dirs)
        {
        //check for the neighbours and if the neighbouring element          is of the same color then change to newColor

            int nr=r+dir[0];
            int nc= c+dir[1];
            dfs(image, nr,nc,newColor);//recursive calls of the 
            //neighbours
        }
    }
}
