// DFS to flood-fill
// TC: O(n) <-- reaching each node just once
// SC: O(h) <-- height of the tree

class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        m = image.length;
        n = image[0].length;
        
        if (initialColor != color) {
            dfs(image, initialColor, color, sr, sc);
        }
        return image;
    }

    public void dfs(int[][] image, int initialColor, int finalColor, int row, int col) {
        if (row >= m || row < 0 || col < 0 || col >= n || image[row][col] != initialColor){
            return;
        }

        image[row][col] = finalColor;
        
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(image, initialColor, finalColor, nr, nc);
        }
    }
}
