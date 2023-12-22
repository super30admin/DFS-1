//T.C O(m*n)
//S.C O(d) recursive stack space d is diagonal length of m*n matrix

//DFS approach to recursively check for
class _01Matrix {
    private int m,n;
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        //edge case
        if(matrix == null || m == 0) return matrix;
        n = matrix[0].length;
        int[][] res = new int[m][n];

        for(int i=0; i<m; i++)
            for(int j=0;j<n;j++)
                res[i][j] = dfs(matrix, res, i,j);

        return res;
    }

    private int dfs(int[][] matrix, int[][] res, int i, int j){
        //base
        if(i<0|| i>=m || j<0 || j>=n) return 9999;
        if(matrix[i][j] == 0) return 0;
        if(i>0 && matrix[i-1][j] == 0) return 1;
        if(j>0 && matrix[i][j-1] == 0) return 1;

        if(i<m-1 && matrix[i+1][j] == 0) return 1;
        if(j<n-1 && matrix[i][j+1] == 0) return 1;

        //Don't have any neighboring zeros

        int top, left, bottom, right;

        top = left = 9999; //declare them as infinity

        if(i>0 && res[i-1][j]!=0){
            top = res[i-1][j];
        }
        if(j>0 && res[i][j-1]!=0){
            left = res[i][j-1];
        }

        bottom = dfs(matrix, res, i+1, j);

        right = dfs(matrix, res, i, j+1);

        return Math.min(Math.min(left, right), Math.min(top, bottom))+1;

    }
}