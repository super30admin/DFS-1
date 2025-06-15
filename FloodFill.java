// Time Complexity :O(m*n)
// Space Complexity :O(m*n)// recursion stack
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Approach : start with the cell at the sr and sc and it's initial color. Call a dfs function that goes through all 4 neighbors, if any of 
// the neighbor is initial color, change it to color and repeat dfs of all of it's neighbors and so on
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int dirs[][] = new int[][]{{-1, 0}, {0,1}, {1, 0}, {0,-1}};
        int initColor = image[sr][sc];
        if(initColor == color){
            return image;
        }
        dfs(image, sr, sc, initColor, color, dirs);
        return image;
    }
    public void dfs(int image[][], int r, int c, int initColor, int color, int dirs[][]){
        if(r<0 || r>=image.length || c<0 || c>=image[0].length || image[r][c]!=initColor){
            return;
        }
        image[r][c] = color;
        for(int dir[]: dirs){
            int nr = r+dir[0];
            int nc = c+dir[1];
            dfs(image, nr, nc, initColor, color, dirs);
        }
    }
}