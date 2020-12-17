// Time Complexity :O(m*n) 
// Space Complexity :O(m*n) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach:Start Dfs from the given cordinate in four directions. if we come across the
// oldcolor, change it to newcolor and mark it as visited and continue dfs for that cordinate only.

class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image== null || image.length==0)
            return null;
        int visited[][] = new int[image.length][image[0].length];
        int oldColor = image[sr][sc];
        dfs(image,sr,sc,newColor,oldColor,visited);
        return image;
    }
    int dir[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(int[][] image, int sr, int sc, int newColor,int oldColor,int[][] visited){
        if(sr <0 || sc <0 || sr>=image.length || sc>= image[0].length || visited[sr][sc]==1)
            return;
        if(image[sr][sc] == oldColor){
        image[sr][sc] = newColor;
        visited[sr][sc]=1;
        for(int d[] : dir){
            dfs( image, sr+d[0], sc+d[1], newColor, oldColor,visited);
        }
        }
    }
}