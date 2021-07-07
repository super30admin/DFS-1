class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        int[][] output = new int[matrix.length][matrix[0].length];
        if(matrix == null || matrix.length < 1)
            return matrix;
        
        updateMatrix(matrix, output);
        return output;
    }
    
    private void updateMatrix(int[][] matrix, int[][] output){
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                int currmax = 99999;
                if(matrix[i][j] == 0)
                    output[i][j] = 0;
                else{
                    for(int[] dir : directions){
                        int row = dir[0] + i;
                        int col = dir[1] + j;
                        if(row >=0 && col >= 0 && row < matrix.length && col < matrix[0].length){
                            if(matrix[row][col] == 0){
                                output[i][j] = 1;
                                break;
                            }
                            else{
                                int curroutput = 1 + nearestZero(matrix,row,col,i,j); 
                                
                                //System.out.println(curroutput);
                                if(curroutput < currmax)
                                    currmax = curroutput;
                                 output[i][j] = currmax;
                            }
                        }
                   
                    }
                        
                }
            }
        }
    }
    private int nearestZero(int[][]matrix, int i, int j,int prev_i, int prev_j){
        for(int [] dir : directions){
            int row = dir[0] + i;
            int col = dir[1] + j;
            
            if(row >=0 && col >= 0 && row < matrix.length && col < matrix[0].length && !(prev_i == row && prev_j == col)){
                if(matrix[row][col] == 0)
                    return 1;
                return 1 + nearestZero(matrix, row, col, i, j);
                
            }
                
        }
        return 0;
    }
}
