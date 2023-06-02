class Solution {
    int m;
    int n;
    int [][]dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        m = image.length;
        n = image[0].length;
        dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int oldColor = image[sr][sc];
        DFS(image,sr,sc,color,oldColor);
        return image;
    }
    
    private void DFS(int[][] image, int sr, int sc, int color,int oldColor){
        //base
        if(sr<0 || sc<0 || sr>=m || sc>=n || image[sr][sc] != oldColor){
            return;
        }        
        //logic
        image[sr][sc] = color;
        
        for(int[] dir : dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            DFS(image,nr,nc,color,oldColor);
        }
    }
}

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
        // base case
        if(i < 0 || i >= m || j < 0 || j >= n) return 9999;
        if(matrix[i][j] == 0) return 0;
        if(i > 0 && matrix[i-1][j] == 0) return 1;
        if(j > 0 && matrix[i][j-1] == 0) return 1;
        if(i < m - 1 && matrix[i+1][j] == 0) return 1;
        if(j < n-1 && matrix[i][j+1] == 0) return 1;
        // Don't have any neighboring zero'
        int top, left, right, bottom;
        top = left = 9999; // Declare them as infinity
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



