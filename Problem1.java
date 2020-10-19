// Time Complexity : O(MN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Using DFS approach


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
     
        int color = image[sr][sc];
        if(color != newColor){
            helper(sr,sc,image, newColor, color);
        }
        return image;
    }
    
    private void helper(int sr, int sc, int[][] image, int newColor, int color){
        if(image[sr][sc] == color){
            
            image[sr][sc] = newColor;
            
            if(sr >= 1)  helper(sr-1,sc,image, newColor, color);
            if(sr+1 < image.length)  helper(sr+1,sc,image, newColor, color);
            if(sc >= 1)  helper(sr,sc-1,image, newColor, color);
            if(sc+1 < image[0].length)  helper(sr,sc+1,image, newColor, color);
        }
    }
}
