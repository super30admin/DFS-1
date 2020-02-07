// S30 Big N Problem #62 {Easy}
// 733. Flood Fill
// Time Complexity :O(m*n)
// Space Complexity :O(m*n) {recursive stack}
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// DFS Solution
class Solution {
    int color=-1;
    int [][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[sr][sc]==newColor) return image;
        color=image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
    }
    
    
    private void dfs(int[][] image, int r, int c, int newColor){
        //base case
        if(r<0 || r>=image.length || c<0 || c>=image[0].length || image[r][c]!=color) return;
        //logic
        image[r][c]=newColor;
        for(int []dir:dirs){
            int i=r+dir[0];
            int j=c+dir[1];
            dfs(image,i,j,newColor);
        }
    }
}