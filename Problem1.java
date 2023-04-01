// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Retrieve the color at the index given and traverse its neighbors. 
If the neighbors equal the original index's color, change its color to new color. 
Do it for all the neighbors and then return. 
 * 
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int dirs[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int m = image.length; 
        int n = image[0].length; 
        if(image[sr][sc] == color){
            return image;
        }
        int orig = image[sr][sc];
        dfs(image, dirs, sr, sc, color, orig, m, n);
        return image;
    }
    private void dfs(int image[][],int dirs[][], int sr, int sc, int color, int orig, int m, int n){
        if(sr < 0 || sc < 0 || sr == m || sc == n ||image[sr][sc] != orig)
            return; 
        image[sr][sc] = color; 
        for(int dir[]: dirs){
            int nr = dir[0] + sr;
            int nc = dir[1] + sc; 
            dfs(image, dirs, nr, nc, color, orig, m, n);
        }
    }
}