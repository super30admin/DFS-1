class Solution {
    int m,n,oriCol;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image== null|| image.length==0||image[sr][sc]==newColor){
            return image;
        }
        m=image.length;
        n=image[0].length;
        oriCol=image[sr][sc];
        dfs(image,newColor,sr,sc);
        return image;
    }
    private void dfs(int[][] image,int newColor,int sr,int sc){
        //base
        if(sr<0 || sc<0 || sr == m || sc == n || image[sr][sc]!=oriCol){
            return;
        }
        //logic
        image[sr][sc]=newColor;
        int [][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        for(int [] dire:dir){
            int r= sr + dire[0];
            int c= sc + dire[1];
            dfs(image,newColor,r,c);
            
        }
    }
}