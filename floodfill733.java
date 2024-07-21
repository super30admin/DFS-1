// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        helper(sr,sc,color, image[sr][sc], image);
        return image;
    }
    public void helper(int i, int j, int color, int rootcolor, int[][] image){
        if(!isValid(i,j,image)) return;
        if(image[i][j] != rootcolor || image[i][j] == color) return;
        image[i][j] = color;
        helper(i-1,j,color,rootcolor, image);
        helper(i,j-1,color,rootcolor, image);
        helper(i+1,j,color,rootcolor, image);
        helper(i,j+1,color,rootcolor, image);
    }

    public boolean isValid(int i, int j,int[][] image){
        return i>=0 && j>=0 && i<image.length && j<image[0].length;
    }
}