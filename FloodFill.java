// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// DFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null && image.length==0)
            return new int[0][];
       
        int orig = image[sr][sc];
        dfs(image, sr, sc, newColor, orig);
        return image; 
    }
    
    private void dfs(int[][] image, int i, int j, int newColor, int orig){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]==newColor)
            return;
        
        if(image[i][j] == orig){
            image[i][j]=newColor;
            dfs(image, i+1, j, newColor, orig);
            dfs(image, i-1, j, newColor, orig);
            dfs(image, i, j+1, newColor, orig);
            dfs(image, i, j-1, newColor, orig);
        }
    }
}