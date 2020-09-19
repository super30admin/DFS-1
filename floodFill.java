// Time Complexity :O(N) N is total number of pixels
// Space Complexity :recursion stack + O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image [sr][sc] == newColor) 
            return image;
        
        helper(sr,sc,newColor, image, image [sr][sc] );
        
        return image;
        
    }
    int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    private void helper(int sr, int sc, int newColor, int [][] image, int oldColor){
        if(sr < 0 || sr >=image.length || sc < 0 || sc >= image[0].length || 
           image[sr][sc] !=oldColor ) return;
        
        image[sr][sc] = newColor;
        
        for(int [] dir : dirs){
            int x = sr+dir[0];
            int y = sc+dir[1];
            
            helper(x,y,newColor, image, oldColor);
        }
    } 
}
