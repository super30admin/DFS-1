/**LC-773
 * Time Complexity : O(MN) 
 * Space Complexity : O(MN) 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. If startColor ==  newColor, terminate and don't perform dfs
 2. Start with sr and sc and recursive iterate in all directions
 */
class Solution {
    
    int startColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        //edge 
        if(image == null || image.length == 0) return image;
        startColor = image[sr][sc];
        if(startColor == newColor) return image;
        
        dfs(image, sr, sc, newColor);
        
        return image;
    }
    
    public void dfs(int[][] image, int i, int j, int newColor){
        
        //base'
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != startColor) return;
        
        //logic
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        image[i][j] = newColor;
        for(int[] dir: dirs){
            
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(image, r, c, newColor);
        }
        
    }
}