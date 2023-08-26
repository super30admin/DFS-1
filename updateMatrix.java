class Solution {
    private int rows;
    private int cols;

    public int[][] updateMatrix(int[][] matrix) {
        rows = matrix.length;
        if(matrix == null || rows == 0) return matrix;

        cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = dfs(matrix, result, i, j);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int[][] result, int i, int j) {
        if(i < 0 || i >= rows || j < 0 || j >= cols) return 9999;
        if(matrix[i][j] == 0) return 0;

        if(i > 0 && matrix[i-1][j] == 0) return 1;
        if(j > 0 && matrix[i][j-1] == 0) return 1;
        if(i < rows - 1 && matrix[i+1][j] == 0) return 1;
        if(j < cols-1 && matrix[i][j+1] == 0) return 1;

        int top = i > 0 && result[i-1][j] != 0 ? result[i-1][j] : 9999;
        int left = j > 0 && result[i][j-1] != 0 ? result[i][j-1] : 9999;
        int bottom = dfs(matrix, result, i+1, j);
        int right = dfs(matrix, result, i, j+1);

        return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1;
    }
public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1,1,1}};
        
        Solution solution = new Solution();
        int[][] updatedMatrix = solution.updateMatrix(mat);
        
        // Printing the updated matrix
        for (int i = 0; i < updatedMatrix.length; i++) {
            for (int j = 0; j < updatedMatrix[0].length; j++) {
                System.out.print(updatedMatrix[i][j] + " ");
            }
            System.out.println(); // 0 0 0, 0 1 0 , 1 2 1 
        }
    }
    
}
