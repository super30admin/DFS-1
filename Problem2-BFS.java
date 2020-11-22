class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    q.offer(new int[]{i,j});
                }
                else{
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while(!q.isEmpty()){
            int[] top = q.poll();
            
            for(int k = 0; k<dirs.length;k++){
                int r = top[0] + dirs[k][0]; // getting row
                int c = top[1] + dirs[k][1]; // getting column
                
                if(r < 0 || c < 0 || r > m-1 || c > n-1 || matrix[r][c]<=matrix[top[0]][top[1]]+1){
                    continue;
                }
                q.offer(new int[] {r,c});
                matrix[r][c] = matrix[top[0]][top[1]]+1;
                                                                                
                
            }
        }
        return matrix;
        
    }
}