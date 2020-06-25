// Time Complexity :O(m*n) m is the length and n is breadth of the image
// Space Complexity :O(m*n) m is the length and n is breadth of the image
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int[][] dirs;
    int m; int n;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length==0 || image[sr][sc] == newColor) return image;
        color = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        
        dfs(image,sr,sc,newColor);
        return image;
        
        }
        
    public void dfs(int[][] image, int sr, int sc, int newColor){
        //base case
        if(sr<0 || sc<0|| sc>=n || sr>=m || image[sr][sc] != color) return;
        //logic
        image[sr][sc] = newColor;
        for(int[] dir : dirs){
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(image,r,c,newColor);
        }
    }
    }
