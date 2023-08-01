//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

class Solution {
    int[][] dirs;
    int m, n, originalColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image.length == 0 || image == null || image[sr][sc] == color) {
            return image;
        }
        m = image.length;
        n= image[0].length;
        originalColor = image[sr][sc];
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
        dfs(image, sr, sc, color);

        return image;
    }

    private void dfs(int[][] image, int i, int j, int color) {
        if(i < 0 || i == m || j < 0 || j == n || image[i][j] != originalColor) {
            return;
        }

        image[i][j] = color; 

        for(int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(image, nr, nc, color);
        }
    }
}