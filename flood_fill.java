// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    int start;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        start=image[sr][sc];

        if(image[sr][sc]==color) return image;
        helper(image,sr,sc,color);

        return image;
    }
    private void helper(int[][] image, int sr, int sc, int color){
        //Base
        if(sr>=image.length || sr<0 || sc>=image[0].length || sc<0 || image[sr][sc]!=start) return;
        //Logic

        image[sr][sc]=color;


        for(int[] dr : dirs){
            int nr =sr+dr[0];
            int nc = sc+dr[1];
            helper(image,nr,nc,color);
        }
    }
} 