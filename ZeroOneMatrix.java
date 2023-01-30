//BFS solution
// Time Complexity : O(mn)
// Space Complexity : O(mn)

/*
 * the matrix is converted to -1 inplace of 1 and all the 0s are added
 * to the queue. maintain a dist variable and at each level replace it
 * with the -1 and increment the distance. also add it to the queue.
 */

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix == null) return matrix;

        int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int []> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[] {i, j});
                }
                else{
                    matrix[i][j] = -1;
                }
            }
        }

        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] == -1){
                        matrix[nr][nc] = dist;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}

//BFS solution
// Time Complexity : O(mn)^2
// Space Complexity : O(mn)

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