// Time complexity: O(m*n)
// Space complexity: O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // return the matrix if empty
        if(mat.length == 0) return mat;
        // get the number of rows and columns
        int m = mat.length;
        int n = mat[0].length;
        // initialize queue
        Queue<int[]> q = new LinkedList<>();
        // iterate through the matrix,
        // add the index to queue at which 0 is found
        // if 1 is found, mark it visited by assigning -1
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) q.add(new int[] {i, j});
                else mat[i][j] = -1;
            }
        }
        // initialize dirs array
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        // iterate through the queue
        while(!q.isEmpty()){
            // get the row and column from queue
            int[] index = q.poll();
            int row = index[0];
            int col = index[1];
            // iterate through the dirs array and get the rows and columns
            for(int[] dir : dirs){
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;
                // check for boundary conditions
                // if -1 is found, mark the cell with distance from nearest 0 cell and add it to the queue
                if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && mat[newRow][newCol] == -1){
                    mat[newRow][newCol] = mat[row][col] + 1;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
}
