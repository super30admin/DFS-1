class Solution {// Time and space of O(n*m)
    public int[][] updateMatrix(int[][] matrix) {
        //Base Case 
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        int nrows = matrix.length ;
        int ncols = matrix[0].length ;
       Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int[][] dirs = {{-1,0},{0,1},{0,-1},{1,0}};
        //Add zero to the queue as the starting point
        for(int i=0; i<nrows ; i++){
            for(int j = 0 ; j< ncols ; j++){
                if(matrix[i][j] == 0)
                    queue.offer(new Pair(i,j));
                else{
                    matrix[i][j] = Integer.MAX_VALUE ; 
                }
            }
        }
        int size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            Pair<Integer,Integer> curr = queue.poll();// array syntax int[] [0,1]
            int row_idx = curr.getKey();
            int col_idx = curr.getValue();
            for(int[] dir: dirs){
                int new_x = row_idx + dir[0];
                int new_y = col_idx + dir[1];
                if(isValid(new_x,new_y,matrix) && matrix[new_x][new_y] > matrix[row_idx][col_idx] + 1)
                {
                    matrix[new_x][new_y] = matrix[row_idx][col_idx] + 1 ;
                    queue.offer(new Pair(new_x,new_y));
                }
            }
            
        }
        return matrix ;
    }
    
    private boolean isValid(int x , int y , int[][] matrix){
        int nrows = matrix.length ;
        int ncols = matrix[0].length ;
        if(x>=0 && x<nrows && y>= 0 && y< ncols && matrix[x][y] != 0)
            return true;
        return false;
    }
}