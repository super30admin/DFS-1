// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int[][] dirs;
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        m = image.length;
        n = image[0].length;
        dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};

        if(image[sr][sc] == color) return image;
        int currColor = image[sr][sc];
        dfs(image, sr, sc, color, currColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int currColor){
        //base
        if(r < 0 || c < 0 || r == m || c == n || image[r][c] != currColor) return;

        //logic
        image[r][c] = color;
        for(int[] dir: dirs){
            int nr = r+ dir[0];
            int nc = c + dir[1];
            dfs(image, nr, nc, color, currColor);
        }
    }
}

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    private int m;
    private int n;
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        // edge case
        if(matrix == null || m == 0) return matrix;
        n= matrix[0].length;
        int [][] result = new int [m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = dfs(matrix,result, i, j);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int [][] result,int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n) return 9999;
        if(matrix[i][j] == 0) return 0;
        if(i > 0 && matrix[i-1][j] == 0) return 1;
        if(j > 0 && matrix[i][j-1] == 0) return 1;
        if(i < m - 1 && matrix[i+1][j] == 0) return 1;
        if(j < n-1 && matrix[i][j+1] == 0) return 1;
        int top, left, right, bottom;
        top = left = 9999; 
        if(i > 0 && result[i-1][j] != 0){
            top = result[i-1][j];
        }
        if(j > 0 && result[i][j-1] != 0){
            left = result[i][j-1];
        }
        bottom = dfs(matrix, result, i+1, j);
        right = dfs(matrix, result, i, j+1 );
        return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1;
    }
}
