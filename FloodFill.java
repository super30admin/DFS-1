// Time Complexity : O(mxm) where m and n rows and column length of image matrix
// Space Complexity : O(mxn)where m and n rows and column length of image matrix
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes

public class FloodFill{

}
class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1},{-1,0},{1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0){
            return image;
        }
        //get the color which needs to be filled
        int color = image[sr][sc];
        if(color == newColor){
            return image;
        }
        dfs(image, sr, sc, newColor, color);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor, int color){
        //base
        //check for bounds and if the cell is valid to fill newColor
        if(sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 || image[sr][sc] != color){
            return;
        }
        
        //logic
        image[sr][sc] = newColor;
        //move in four directions : Up, Left, down, right and keep calling dfs
        for(int[] dir: dirs){
            dfs(image, sr+dir[0], sc+dir[1], newColor, color);
        }
    }
}