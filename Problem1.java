// Time complexity: O(m*n)
// Space complexity: O(m*n)

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // Edge cases
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return matrix;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                else{
                    q.add(new int[] {i,j});
                }
            }
        }
        
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i<size; i++){
                int[] root = q.poll();
                
                int root_i = root[0];
                int root_j = root[1];
                 
                for(int[] direction: dirs){
                    int r = root_i + direction[0];
                    int c = root_j + direction[1];
                    
                    if(r >= 0 && r < row && c >= 0 && c < col && (matrix[root_i][root_j] + 1 < matrix[r][c])){
                        q.add(new int[] {r,c});
                        matrix[r][c] = matrix[root_i][root_j] + 1;
                    }                    
                 }
            }
        }
        
        return matrix;
    }
}
