// Time Complexity : O(m * n) 
// Space Complexity : O(m * n)

public class Zero_One_Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] op = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    op[i][j] = 0;
                } else {
                    op[i][j] = 10000;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (i > 0) {
                        op[i][j] = Math.min(op[i][j], op[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        op[i][j] = Math.min(op[i][j], op[i][j - 1] + 1);
                    }
                }
            }
        }
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    if (i < m - 1) {
                        op[i][j] = Math.min(op[i][j], op[i + 1][j] + 1);
                    }
                    if (j < n - 1) {
                        op[i][j] = Math.min(op[i][j], op[i][j + 1] + 1);
                    }
                }
            }
        }
        
        return op;
    }
}

