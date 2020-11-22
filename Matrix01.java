class Matrix01 {
    // Approach 1 - BFS
    // Time complexity - O(m*n)
    // Space complexity - (O(m*n))
    
    // This function is calculating the distance of non-zero cell from the closet zeroth cell and update into the cell.
    public int[][] updateMatrix(int[][] matrix) {
        
        // Queue to keep track of neighbour of a node which is having non-zero value
        Queue<int[]> queue = new LinkedList<>();
        
        // Store indexes of cell having zero value and replacing other values with a Integer max value.
        for(int i=0; i<matrix.length; i++){
            for(int j=0;j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
                else if(matrix[i][j] == 1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            } 
        }
        
        // Valid directons of traversal
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        
        // Loop till queue is empty
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            //for each entry in the queue calculate next non-zeroth neighbour and replace the value with the depth of the traversal.
            for(int[] dir : directions){
                int r = temp[0]+dir[0];
                int c = temp[1]+dir[1];
                
                if(r <0 || r >= matrix.length || c < 0 || c >= matrix[0].length || matrix[r][c] <= matrix[temp[0]][temp[1]]+1)
                    continue;
                queue.offer(new int[]{r,c});
                matrix[r][c] = matrix[temp[0]][temp[1]] +1;
             }
        }
        return matrix;
    }
}