package DFS1;
// Time Complexity : O(mxn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class FloodFill {
    int [][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor)
            dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int newColor, int oldColor){
        //base
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor)
            return;
        //logic
        image[r][c] = newColor;
        for(int[] dir : dirs){
            int nr = r  + dir[0];
            int nc = c + dir[1];
            dfs(image, nr, nc, newColor, oldColor);
        }
    }

    public static void main(String[] args) {
        System.out.println(new FloodFill().floodFill(new int[][]{{0,0,0},{0,0,0}}, 0, 0, 2));
    }
}
