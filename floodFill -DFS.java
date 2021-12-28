// Time Complexity :O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode 733: yes
/*Approach: we have to check if given cell has the newColor already if so we can return the input matrix as it is
else we will have to change the present color of the given cell to a new color and also all its neighbors
(in the 4 directions)having the old color of the given cell to the new cell*/

class Solution {
    int m,n,color;
        int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null||image.length==0||image[sr][sc]==newColor)
            return image;
       m =image.length;
       n=image[0].length;
       color=image[sr][sc];

     dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        dfs(sr,sc,image,newColor);
       return image;

    }
private void dfs(int sr,int sc,int[][] image,int newColor){
   if(sr<0||sc<0||sr>=m||sc>=n||image[sr][sc]!=color)
       return;
       image[sr][sc]=newColor;

            for(int[] dir:dirs){
                int nr=sr+dir[0];
                int nc=sc+dir[1];
                dfs(nr,nc,image,newColor);

}

}
}