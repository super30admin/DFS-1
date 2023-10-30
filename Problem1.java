// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    int[][] dirs;
    int m , n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.m = image.length;
        this.n = image[0].length;
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        if(image[sr][sc]==color)
            return image;
        helper(image,sr,sc,color,image[sr][sc]);
        return image;
        
    }
    private void helper(int[][] image, int sr, int sc, int color,int curr){
        if(sr < 0 || sr >= image.length || sc < 0|| sc >=image[0].length || image[sr][sc]!=curr)
            return;
        image[sr][sc]=color;
        System.out.println("sr:"+sr+" sc: "+sc);
        for(int[] dir : dirs){
            int nr = dir[0]+sr;
            int nc = dir[1]+sc;
            helper(image,nr,nc,color,curr);
        }
    }
}
