// Time Complexity : O(n)
// Space Complexity : O(h), h - height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class FloodFill {
    int color;
    int m; int n;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }
        color = image[sr][sc];
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    public void dfs(int[][] image, int row, int col, int newColor){
        if(row < 0 || col < 0 || row == m || col == n || image[row][col] != color){
            return;
        }
        
        image[row][col] = newColor;
        
        for(int[] dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(image, r, c, newColor);
        }
    }
}