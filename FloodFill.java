/**
 * @author Vishal Puri
 * // Time Complexity : O(m*n)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class FloodFill {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(image==null || image[sr][sc]== newColor) return image;
        m = image.length;
        n = image[0].length;
        image[sr][sc] = newColor;
        helper(image, sr, sc, oldColor, newColor);
        return image;
    }
    private void helper(int[][] image, int r, int c, int oldColor, int newColor){
        //base

        //logic
        for(int[] dir : dirs){
            int nr = dir[0]+r;
            int nc = dir[1]+c;
            if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==oldColor){
                image[nr][nc] = newColor;
                helper(image, nr, nc, oldColor, newColor);
            }
        }
    }
}
