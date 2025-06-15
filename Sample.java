// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            for (int[] dirs : dir) {
                int row = r + dirs[0];
                int col = c + dirs[1];
                if (row >= 0 && row < m && col >= 0 && col < n && mat[row][col] == -1) {
                    mat[row][col] = mat[r][c] + 1;

                    q.add(new int[] { row, col });
                }

            }

        }
        return mat;

    }
}

//
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalcolor = image[sr][sc];
        if (originalcolor == color) {
            return image;
        }
        dfs(image, sr, sc, originalcolor, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalcolor, int color) {
        // base
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }
        if (image[r][c] != originalcolor) {
            return;
        }
        image[r][c] = color;

        // logic
        dfs(image, r + 1, c, originalcolor, color);
        dfs(image, r - 1, c, originalcolor, color);
        dfs(image, r, c + 1, originalcolor, color);
        dfs(image, r, c - 1, originalcolor, color);

    }

}