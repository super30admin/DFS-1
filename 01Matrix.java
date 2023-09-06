//// Time Complexity : O(m⋅n)
// Space Complexity :O(m⋅n)
//Here we are using direction matrix to get the distance.

class Matrix01{
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = new int [][] {{0,1}, {0,-1}, {-1,0}, {1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n ; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = -1;
                }else{
                    q.add(new int[]{i,j});
                }
            }
        }
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nc >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1){
                        matrix[nr][nc] = dist;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}