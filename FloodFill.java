class Solution {
// Time Complexity : O(m*n)  when are all are 1's
// Space Complexity : O(m*n) when are all are 1's
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Use dfs method through recursion and traverse till all the connected 1's are covered.
 */
    
    int color;
    Queue<int[]> q;
    int[][] dirs;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length==0 || newColor==image[sr][sc]) return image;
        color = image[sr][sc];
        dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        q = new LinkedList<>();
        dfs(image,sr,sc,newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor){
        //base
        if(sr<0 || sr>=image.length ||sc<0 || sc>=image[0].length || image[sr][sc]!=color)    return;
        //logic
        image[sr][sc] = newColor;
        for(int[] dir : dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image,r,c,newColor);
        }
    }
}