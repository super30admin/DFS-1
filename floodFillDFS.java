// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        int m = image.length;
        int n = image[0].length;
        dirs = new int[][] {{1,0},{-1,0},{0,-1},{0,1}};

        if(image[sr][sc] == color) return image;
        int ogColor = image[sr][sc];
        dfs(image,sr,sc,color,m,n,ogColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int m, int n, int ogColor){
        //base
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != ogColor){
            return;
        }

        image[sr][sc] = color;
        for(int[] dir : dirs){
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            dfs(image, nr, nc, color, m ,n, ogColor);
        }
    }
}