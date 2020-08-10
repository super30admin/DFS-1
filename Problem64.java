Time Complexity - O(N) where N is the no of cells in the matrix
Space Complexity - O(N) where N is the no of cells in the matrix


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] directions = {{0,1}, {1,0}, {0,-1},{-1,0}};
        if(matrix == null && matrix.length<1) return matrix;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0) q.offer(new int[]{i,j});
                else if(matrix[i][j] == 1) matrix[i][j] = -1;
            }
        }
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int[] dir : directions){
                int r = temp[0]+dir[0];
                int c = temp[1]+dir[1];
                if(r>=0 && r<matrix.length && c>=0 && c<matrix[0].length && matrix[r][c] == -1){
                    matrix[r][c] = matrix[temp[0]][temp[1]] + 1;
                    q.offer(new int[]{r,c});
                }
            }
        }
        return matrix;
    }
}