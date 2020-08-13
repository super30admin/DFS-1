//DFS solution
//time complexity: O(m*n) we are going to visit all nodes in worst case
//space complexity:O(m*n) if every cell has the original color
//executed on leetcode: yes
/**
1. intially, if image is null, its length is 0 or if the starting pixel is having new color, we wont proceed further and return the original array
2. we change the color of the present cell to new color and for every present cell, we check in all four directions, if the neighbouring cell has the original color, we visit it and change its color and so on. 
**/

class Solution {
    int original;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[sr][sc]==newColor) return image;
        original = image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor)
    {
        //base
        
        if(sr==-1 || sr==image.length || sc==-1 || sc==image[0].length || image[sr][sc]!=original) return; 
        //logic
        image[sr][sc] = newColor;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir : dirs)
        {
            int r = dir[0]  + sr;
            int c = dir[1] + sc;
            dfs(image,r,c,newColor);
        }
    }
}