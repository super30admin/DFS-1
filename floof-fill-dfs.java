class Solution {
    // DFS Solution
    // Time compplexity is O(mn)
    // Space complexity is O(mn)
    // This solution is submitted on leetcode with zero errors
    private int rowLen;
    private int colLen;
    private int prevCol;
    private int [][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        rowLen = image.length;
        colLen = image[0].length;
        // Saving previous color
        prevCol = image[sr][sc];
        //Edge case
        if(image == null || rowLen == 0 || prevCol==newColor) return image;
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor){
        // base case
        if(sr<0 || sc<0 || sr == rowLen || sc == colLen || image[sr][sc] !=prevCol) return;
        
        //logic
        image[sr][sc] = newColor;
        for(int [] dir: dirs){
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(image, r,c,newColor);
        }
    }
}