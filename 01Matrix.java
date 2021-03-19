class Solution {
    
    int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0,1}, {0,-1}};
    
    public int[][] updateMatrix(int[][] matrix) {
        //edge case
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return matrix;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                //replace all 0's by 0 and add to queue
                if(matrix[i][j] == 0){
                    matrix[i][j] = 0;
                    queue.add(new int[]{i, j});
                }else if(matrix[i][j] == 1){ 
                    //if encounter 1 replace it with max value
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!queue.isEmpty()){
            //get an element from the queue
            int[] rc = queue.poll();
            
            int r1 = rc[0];
            int c1 = rc[1];
            
            //itreate through dirs array from all 4 diections
            for(int i = 0; i < dirs.length; i++){
                //calculate row and cols
                int r2 = r1 + dirs[i][0];
                int c2 = c1+ dirs[i][1];
                
                //do some sanity check 
                if(r2 >= 0 && r2 < rows && c2 >=0 && c2 < cols && matrix[r2][c2] == Integer.MAX_VALUE){
                    
                    //add the row and col to queue
                    //update the distance to reach 0 
                    queue.add(new int[]{r2, c2});
                    matrix[r2][c2] = matrix[r1][c1] + 1;
                }
                
            }
        }
        //retrun matrix
        return matrix;
    }
}

//n -> number of rows
//m -> number of cols


//Time Complexity : O(n*m*4) -> O(n*m)
// Space Complexity: O(1)