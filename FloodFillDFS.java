public class FloodFillDFS {
    int m,n, color;
    int[][] dirs;


    // DFS approach - Put the elements in 4 directions one-by-one in a recursion stack
    // TC: O(m * n) -> m is the number rows & n is the number of columns
    // SC: O(m * n)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;

        m = image.length;
        n = image[0].length;

        // Direction array
        dirs = new int[][]{
                {0,1},
                {0, -1},
                {1,0},
                {-1,0}
        }; // R, L, D, U

        // Find out the color at the given co-ordinates. We need to replace this color wherever we find this.
        color = image[sr][sc];

        dfs(sr, sc, newColor, image);

        return image;

    }

    private void dfs(int sr, int sc, int newColor, int[][] image) {

        // base condition to terminate the recursion
        // If the current color is not the color we are elooking for, terminate the recursion
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color) return;
        // logic
        image[sr][sc] = newColor;
        for(int[] dir : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];

            dfs(r,c,newColor,image);
        }
    }
}
