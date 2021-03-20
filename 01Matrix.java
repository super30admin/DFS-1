class 01Matrix {
    
    // Time Complexity: O(nm)   (where n -> no. of rows and m -> no. of cols)
    // Space Complexity: (nm)
    
    public int[][] updateMatrix(int[][] matrix) {
        // Edge Case Checking
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return matrix;
        
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        // Traversing the matrix and adding elements that are zero in the queue
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        // directions - up, down, left, right
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Perform BFS
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            for(int[] dir: dirs){
                int row = currX + dir[0];
                int col = currY + dir[1];
                
                // If within boundary conditions = we find an univisited node (1), then calculate distance and add that (row, col) to the queue for future exploration
                if(row >= 0 && row < n && col >= 0 && col < m && !visited[row][col]){
                    matrix[row][col] = matrix[currX][currY] + 1;
                    visited[row][col] = true;
                    q.offer(new int[]{row, col});
                }
            }
        }
        return matrix;
    }
}