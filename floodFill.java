// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        int curr = image[sr][sc];
        fill(image, sr,sc,curr, newColor);
        return image;
    }
    public void fill(int[][] image, int sr, int sc, int color, int newcolor){
        //base case
        //if r/c goes out of bounds or we reach a break point in matrix
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
        return;
        //logic
        //fill current cell with new color
        image[sr][sc] = newcolor;
        int [][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}}; 
        //check all 4 directions
        for(int [] dir : dirs){
            int r = sr + dir[0];
            int c = sc + dir[1];
            fill(image, r, c, color, newcolor);
        }
    }
}