Executed in leet code- Yes
Time complexity-o(n)
space complexity-0(n)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
       dfs(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc,int oldColor, int newColor){
        int m= image.length;
        int n=image[0].length;
        if(sr<0 || sc<0 || sr>=m|| sc>=n) return;
        if(image[sr][sc]==oldColor) 
            image[sr][sc]=newColor;
        else return;

        int[][] dirs= new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        for (int[] dir:dirs){
            int r= sr+dir[0];
            int c= sc+dir[1];
            dfs(image,r,c,oldColor,newColor);
        }
    }
}
