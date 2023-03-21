// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        if(image[sr][sc] == newcolor) return image;
        int color = image[sr][sc];
        dfs(image,sr,sc,newcolor,color);
        return image;
    }
    public void dfs(int[][]image,int sr, int sc, int newcolor, int color){
        if(sr<0||sr>=image.length||sc<0||sc>=image[0].length|| image[sr][sc] != color) return ;
        image[sr][sc] = newcolor;
        int[][] dirs = new int[][]
        {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] dir : dirs){
           int r = sr + dir[0];
           int s = sc + dir[1];
    dfs(image,r,s,newcolor,color);
        }
}}