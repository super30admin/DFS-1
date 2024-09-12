class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return matrix;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == 1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }else {
                    q.add(new int[]{i,j});
                }
            }
        }
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for (int x = 0; x<size; x++){
                int[] root = q.poll();
                
                int root_i = root[0];
                int root_j = root[1];
                
                for (int[] directions : dirs){
                    int r = root_i + directions[0];
                    int c = root_j + directions[1];
                    
                    if (r >=0 && r<n && c>=0 && c<m && matrix[root_i][root_j] + 1< matrix[r][c]){
                        q.add(new int[]{r,c});
                        matrix[r][c]= matrix[root_i][root_j]+1;
                    }
                }
            }
            
        }
        
        return matrix;
        
    }
}