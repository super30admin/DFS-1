// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Problem1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int newColor = image[sr][sc];
        dfs(image, sr, sc, color, newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int newColor){ 
        // base case 
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != newColor)
            return;
        //logic 
        image[sr][sc] = color;
        int[][] dirs = new int[][]
        { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        for (int[] dir : dirs)
        {
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c, color, newColor);
        }
    }
}
