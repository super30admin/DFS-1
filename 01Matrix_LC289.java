class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null) return matrix;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        //put all the zeros in queue and mark all the ones to -1
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[] {i,j});
                }
                else
                    matrix[i][j] *= -1; 
            }
        }
        
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int distance = 0;
        
        //bfs level by level
        while(!q.isEmpty()){
            int size = q.size();
            distance++;
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                
                for(int[] dir: dirs){
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    
                    if(r >= 0 && r < n && c >= 0 && c < m && matrix[r][c] == -1){
                        matrix[r][c] = distance;
                        q.add(new int[] {r,c});
                    }
                }
            }
        }
        return matrix;
    }
}