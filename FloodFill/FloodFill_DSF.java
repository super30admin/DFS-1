/* Time Complexity : O(m*n) 
 *  m - rows of the matrix - image
 *  n - cols of the matrix - image */
/* Space Complexity : O(m*n)
*  m - rows of the matrix - image
*  n - cols of the matrix - image */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//DFS Solution

class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};//right,left,down,up
    int m;
    int n;
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        m = image.length;
        n = image[0].length;
        oldColor = image[sr][sc];
        if(image[sr][sc] == color) return image;
        dfs(image, sr, sc, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color){
        //base condition
        if(sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] != oldColor) return;
        //logic
        image[sr][sc] = color;
        for(int[] dir: dirs){
                int nr = sr + dir[0];
                int nc = sc + dir[1];
                dfs(image, nr, nc, color);
        }
    }
}