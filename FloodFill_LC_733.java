/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity - O(M*N)
Space Complexity - O(M*N)
*/
public class FloodFill_LC_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int curColor = image[sr][sc];
        if(curColor != color){
            dfs(image, sr,sc,color,curColor);
        }
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int curColor) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != curColor) return;

        image[sr][sc] = color;

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image,nr,nc,color,curColor);
        }
    }
}



