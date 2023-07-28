package DFS;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

public class FloodFillUsingRecursion {

    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color) return image;

        this.m = image.length;
        this.n = image[0].length;
        int oldColor = image[sr][sc];

        dfs(image,sr,sc, color, oldColor);
        return image;

    }

    public void dfs(int[][] image, int i, int j, int color, int oldColor)
    {
        if(i<0 || i>=m || j<0 || j>=n || image[i][j] != oldColor) return;
        image[i][j] = color;
        for(int[] dir:dirs)
        {
            int r = dir[0]+i;
            int c = dir[1]+j;

            dfs(image,r,c, color, oldColor);

        }
    }
}
