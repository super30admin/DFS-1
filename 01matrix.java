// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
   
    
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return matrix;
        }
        
        int rows=matrix.length;
        int cols = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0;i<rows;i++){
            for(int j=0; j<cols;j++){
                if(matrix[i][j] == 0){
                    //if zero is encountered add i,j to queue
                    //matrix[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
                else if(matrix[i][j] == 1){
                    //if 1 is encountered replace with max
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }  
        }
        //dirs array
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            //poll front of the queue and get row and column
            int[] front = queue.poll();
            int r = front[0];
            int c = front[1];
            
            for(int[] dir:dirs){
                //for each dir, calc the rows and cols
                int rnew = r + dir[0];
                int cnew = c + dir[1];
                
                if(rnew >= 0 && rnew < rows && cnew >= 0 && cnew<cols && matrix[rnew][cnew] == Integer.MAX_VALUE){
                    //add row and col to queue
                    queue.add(new int[]{rnew,cnew});
                    //update the distace
                    matrix[rnew][cnew] = matrix[r][c] + 1;
                }
            }
        }
        
        return matrix;
    }
}
