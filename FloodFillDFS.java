// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class FloodFillDFS {
    int m,n;
    int[][] dirs;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //dfs

        if(image == null || image.length == 0|| image[sr][sc] == newColor){
            return image;
        }

        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{-1,0},{0,-1},{0,1},{1,0}}; // Up Left Right Down
        color = image[sr][sc];

        dfs(image, sr, sc, newColor);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor){

        if(sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] == newColor || image[sr][sc] != color){
            return;
        }

        image[sr][sc] = newColor;
        for(int[] dir : dirs){
            dfs(image, sr + dir[0], sc + dir[1], newColor);
        }
    }
}
