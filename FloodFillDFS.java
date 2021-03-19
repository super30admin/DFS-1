// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[0].length == 0){
            return image;
        }
        
        //last testcase [[0,0,0],[0,1,1]],1,1,1 
        //since infinite loop for if the newColor is not checked to the original array.
        if(newColor==image[sr][sc]){
            return image;
        }
        
        int rows=image.length;
        int cols=image[0].length;
        int source = image[sr][sc];
        dfs(image,sr,sc,newColor,rows,cols,source);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int rows, int cols, int source){
        if(sr < 0 || sc<0 || sr >=rows || sc>=cols){
            return;
        }
        
        //check if image curr pixel color== source color
        else if(image[sr][sc] != source){
            return;
        }
        
        //else assign the curr pixel color to newColor
        image[sr][sc] = newColor;
        
        dfs(image,sr-1,sc,newColor,rows,cols,source);
        dfs(image,sr+1,sc,newColor,rows,cols,source);
        dfs(image,sr,sc-1,newColor,rows,cols,source);
        dfs(image,sr,sc+1,newColor,rows,cols,source);
    }
}