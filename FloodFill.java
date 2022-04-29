//TC : O(MxN) SC :O(MxN)
class Solution {
    int currentColor;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0) return image;
        if(image[sr][sc] == newColor) return image;
        currentColor = image[sr][sc];
        dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};//R,L,U,D
        helper(image,sr,sc,newColor);
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int newColor){
        //base
        if(sr<0 || sr==image.length || sc<0 || sc==image[0].length||image[sr][sc]!=currentColor) return;
        //logic

        image[sr][sc] = newColor;

        for(int[] dir : dirs)
        {
            int r= sr+dir[0];
            int c= sc+dir[1];
            helper(image,r,c,newColor);
        }
    }

}