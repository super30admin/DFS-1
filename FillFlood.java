class FillFlood {
    // Time Complexity: O(m*n) -- some cells we revisit and some not at all 
    //                     --> asymptomatically O(m*n)
    // Space Complexity: O(m*n)  --> queue
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0][0];
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // directions array for traversing
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        Queue<int[]> queue = new LinkedList<>();
        
        
        // We start from cells having value as 0 instead of 1
        // Updating the distance from each cell to next cell when the distance is
        // less compared to the cell value.
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0)
                    queue.add(new int[]{i,j});
                else if(matrix[i][j] == 1)
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int r, c, i , j;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            i = cell[0];
            j = cell[1];
            for(int[] dir : directions){
                r = i + dir[0];
                c = j + dir[1];
                if(r >= 0 && r < rows && c >= 0 && c < cols && matrix[i][j] + 1 < matrix[r][c] ){
                    matrix[r][c] = matrix[i][j] + 1;
                    queue.add(new int[]{r,c});      // added to queue to update the neighbours of this cell - as distance changes 
                }
            }
        }
        return matrix;
    }
}