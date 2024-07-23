// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image ==null) return image;
        int [][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};

        int m = image.length;
        int n = image[0].length;

        int startColor = image[sr][sc];
        if(image[sr][sc]==color) return image;
        dfs(image,sr,sc,color,startColor, dirs);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color,int startColor, int [][] dirs){

        if(sr<0 || sc<0 || sr>image.length-1 || sc>image[0].length-1 || image[sr][sc]!= startColor) return;

        image[sr][sc]=color;
        for(int [] dir:dirs){
            int cr = dir[0]+sr;
            int cc =  dir[1]+sc;
            dfs(image,cr,cc,color,startColor,dirs);
        }
    }
}