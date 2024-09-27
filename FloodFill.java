// Time Complexity : O(NxM)N=number of rows in matrix and M number of columns in matrix . 
// Space Complexity : O(1) with recursion, with recursion, the recursive stack is O(MaxDepth)
// and the worse case is all oranges are rotten.
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses the DFS traversal and we only change color when image[sr][sc]!=srColor and valid indices;
//Success
//Details 
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Flood Fill.
//Memory Usage: 40.3 MB, less than 89.47% of Java online submissions for Flood Fill.

class Solution {
   public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       if (image==null || image.length==0 || image[sr][sc]==newColor) return image;
        int srColor= image[sr][sc];
        dfs(image, sr,sc, srColor,newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int srColor,int newColor){
        if (sr<0 || sr >= image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=srColor)
            return;
        if (image[sr][sc]==srColor)
            image[sr][sc]=newColor;
        dfs(image,sr-1,sc,srColor,newColor);
        dfs(image,sr+1,sc,srColor,newColor);
        dfs(image,sr,sc+1,srColor,newColor);
        dfs(image,sr,sc-1,srColor,newColor); 
    }
}