/**
 * Time Complexity: O(rows x cols)
 * Space Complexity: O(rows x cols)
 * LeetCode: Y(https://leetcode.com/problems/01-matrix/)
 * Approach: 
 *   Use a BFS to find the minimum distance of each 1 to a 0
 *   First enqueue all 0s in the matrix and mark their distnace to nearest zero as 0
 *   Then compare the neighboring nodes distance with their current distance and new distance (1 + distance of current grid position) and 
 *   update if the new distance is less
 *   if the neighboring node distance is updated then enqueue the neighboring node 
 * 
 */

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // Initialize result matrix
        int[][] result = new int[matrix.length][matrix[0].length];
        
        // Populate all elements to +INF initially
        Arrays.stream(result).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        
        // intialize a queue to hold the row number and col number of a cell
        Queue<int[]> q = new LinkedList<>();
        
        // get rows and cols in a matrix
        int rows = matrix.length, cols = matrix[0].length;
        
        // Iterate through the matrix 
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                // look for 0's
                if(matrix[i][j] == 0) {
                    // update cell distance to 0
                    result[i][j] = 0;
                    
                    // enqueue cell with value 0
                    q.add(new int[]{i, j});
                }
            }
        }
        
        // dirs array to look in the 4 neighboring grids
        int[] dirs = {-1, 0, 1, 0, -1};
        
        // loop until the entire matrix is traversed
        while(!q.isEmpty()) {
            // remove and get the cell position at the front of the queue
            int[] current = q.poll();
            
            // get row number of current cell
            int currentRow = current[0];
            
            // get col number of cuurent cell
            int currentCol = current[1];
            
            // look at 4 neighboring nodes of current cell
            for(int i = 0 ; i < 4 ; i++) {
                // get row number of neighboring cell
                int neighborRow = currentRow + dirs[i];
                
                // get col number of neighboring cell
                int neighborCol = currentCol + dirs[i + 1];
                
                /*  check if neighboring cell is a valid cell and 
                    if the distance of neighboring cell to nearest 0 through the current cell is less 
                    than the current distance of neighboring cell to nearest 0  */
                if(isMatrixPositionValid(neighborRow, neighborCol, rows, cols) && result[neighborRow][neighborCol] > (result[currentRow][currentCol] + 1)) {
                    // update the new less dstance for the neighboring cell
                    result[neighborRow][neighborCol] = result[currentRow][currentCol] + 1;
                    
                    // enqueue the neighboring cell
                    q.add(new int[]{neighborRow, neighborCol});
                }
            }
        }
        
        // return calcualted result
        return result;
    }
    
    /* Helper function to check if the current position is within the dimensions of the matrix */
    private boolean isMatrixPositionValid(int row, int col, int totalRows, int totalCols) {
        return (row >= 0 && col >= 0 && row < totalRows && col < totalCols);
    }
}
