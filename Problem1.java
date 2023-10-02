// Time Complexity : O(m x n) where m is the number of rows and n is the number of columns
// Space Complexity : O(m x n) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    int m, n, originalColor;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color){
            return image;
        }

        m = image.length;
        n = image[0].length;
        originalColor = image[sr][sc];
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        dfs(image, sr, sc, color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color){
        //base case
        if(sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != originalColor){
            return;
        }

        image[sr][sc] = color;
        for(int[] dir: dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color);
        }
    }
}
