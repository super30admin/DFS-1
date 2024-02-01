// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// flood fill on a given image starting from a
// specified pixel location, updating pixels of the same color to a new color
class Problem2 {
    int m, n;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int newColor, color;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.newColor = color;
        this.color = image[sr][sc];
        if(image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc);
        return image;
    }
    private void dfs(int[][] image, int i, int j) {
        // base
        if(i < 0 || i >= m || j < 0 || j >= n || image[i][j] != color) {
            return;
        }
        // logic
        image[i][j] = newColor;
        for(int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];
            dfs(image, r, c);
        }
    }
}
