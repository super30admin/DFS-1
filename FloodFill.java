// Time Complexity : O(N), N = total pixels, m*n
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class FloodFill {
    private int m;
    private int n;
    private int[][]  dirs;
    int prevColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        prevColor = image[sr][sc];
        dirs = new int[][]{{0,-1}, {-1,0},{0,1},{1,0}};
        if(prevColor != newColor)
            dfs(image,sr,sc,newColor);
        return image;
    }

    private void dfs(int[][] image,int row, int  col, int newColor) {

        //base
        if(row<=0 && col<=0 && row==m && col==n) return;

        //logic
        image[row][col] = newColor;
        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if(r>=0 && c>=0 && r<m && c<n){
                if(image[r][c] == prevColor) {
                    image[r][c] = newColor;
                    dfs(image,r,c,newColor);
                }
            }
        }
    }
}
