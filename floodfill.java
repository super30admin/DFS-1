// Time Complexity : O(m*n)
// Space Complexity : O(m*n) All same color
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach

class Solution {
    int old_Color;
    int new_Color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[sr][sc]==newColor)
            return image;
        
        old_Color=image[sr][sc];
        new_Color=newColor;
        
        dfs_helper(sr,sc,image);
        
        return image;
    }
    
    public void dfs_helper(int i, int j, int[][] image)
    {
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=old_Color)
            return;
        
        image[i][j]=new_Color;
        dfs_helper(i+1,j,image);
        dfs_helper(i-1,j,image);
        dfs_helper(i,j+1,image);
        dfs_helper(i,j-1,image);   
    }
}