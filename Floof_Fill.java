// Time Complexity :O(mxn)
// Space Complexity :O(mxn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;        
        if(image!=null||image.length!=0){
            int oldColor = image[sr][sc];
            if(oldColor==newColor)return image;
            helper(image,sr,sc,newColor,m,n,oldColor);
        };
        return image;
    }
    
    public void helper(int[][] image, int x, int y, int newColor, int m, int n, int oldColor){
        if(image[x][y]==oldColor)image[x][y]=newColor;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:dirs){
            int r = dir[0]+x;
            int c = dir[1]+y;
            if(r>=0 && r<m && c>=0 && c<n && image[r][c]==oldColor){
                helper(image,r,c,newColor,m,n,oldColor);
            }
        }
        
    }
}