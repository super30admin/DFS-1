// Time Complexity : O(M * N)
// Space Complexity : O(min(M, N))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FloodFill {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        if(image[sr][sc] == color)
            return image;

        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
    void dfs(int[][] image, int sr, int sc, int origColor, int newColor)
    {
        if(image[sr][sc] == newColor || image[sr][sc] != origColor)
            return;

        if(image[sr][sc] == origColor)
            image[sr][sc] = newColor;

        for(int[] dir : dirs)
        {
            int nr = sr + dir[0];
            int nc = sc + dir[1];

            // bounce check
            if(nr < 0 || nr >= image.length || nc < 0 || nc >= image[0].length)
                continue;

            dfs(image, nr, nc, origColor, newColor);
        }
    }
}
