class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return matrix;
        }
        
        int[][] dir = {{1,0}, {-1, 0}, {0, 1}, {0,-1}};
        int n = matrix.length;
        int m = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix[i][j] == 0){
                    queue.add(new int[] {i, j});
                }
                else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] front = queue.poll();
            for(int[] d: dir){
                int i = front[0] + d[0];
                int j = front[1] + d[1];
                
                if(i>=0 && i<n && j>=0 && j<m && matrix[front[0]][front[1]]+ 1 < matrix[i][j]){
                    queue.add(new int[]{i,j});
                    matrix[i][j] = 1 + matrix[front[0]][front[1]];
                }
            }
        }
        return matrix;
    }
}
