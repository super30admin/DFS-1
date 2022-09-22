// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Start from given row and col, perform DFS in all 4 dirs, convert all oldColor to newColor,
if already newColor then return.
*/
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null) return new int[][]{};
        if(image[sr][sc]==color) return image;
        helper(image, sr,sc,color,image[sr][sc]);
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int newColor, int oldColor){
        if(sr<0 || sc<0 || sr>image.length-1 || sc>image[0].length-1) return;
        if(image[sr][sc]!=oldColor) return;

        image[sr][sc]=newColor;
        helper(image,sr+1,sc,newColor,oldColor);
        helper(image,sr-1,sc,newColor,oldColor);
        helper(image,sr,sc+1,newColor,oldColor);
        helper(image,sr,sc-1,newColor,oldColor);
    }
}