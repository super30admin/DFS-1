// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int color;
    int m;
    int n;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image ==null ||image.length==0||image[sr][sc]==newColor) return image;
        m = image.length;
        n = image[0].length;
        color = image[sr][sc];
        dirs = new int[][]{{-1,0},{0,1},{0,-1},{1,0}}; // U R L D
        dfs(image,sr,sc,newColor);
        return image;
    }
    
    private void dfs(int[][]image,int sr, int sc, int newColor){
        if(sr>=0 && sr<m && sc>=0 && sc<n && image[sr][sc]==color){
            image[sr][sc] = newColor;
            for(int[] dir: dirs){
                int nr = sr+dir[0];
                int nc = sc+dir[1];
                dfs(image,nr,nc,newColor);
            }
        }
    }
}