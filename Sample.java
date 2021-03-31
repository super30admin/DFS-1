TC:O(n*m)
SC:O(n*m)

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return matrix;
        
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i =0; i<n; i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
                else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }            
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()){
            int[] front = queue.poll();
            
            for(int[] dir : dirs){
                int i = front[0] + dir[0];
                int j = front[1] + dir[1];
                
                if(i>=0 && i<n && j>=0 && j<m && (matrix[front[0]][front[1]] + 1 < matrix[i][j])){
                    queue.add(new int[]{i,j});
                    matrix[i][j] = 1 + matrix[front[0]][front[1]];
                                                        
                }
            }
        
        }
        return matrix;
                                                        
    }
}
                                                       