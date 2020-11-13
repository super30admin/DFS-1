/**
 * TC : O(mn) SC : O(mn)
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0) return matrix;
        int m = matrix.length, n = matrix[0].length;
        int dis = 1;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = -1;
                }else if(matrix[i][j]  == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){    
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1){
                        matrix[r][c] = dis;
                        q.offer(new int[]{r,c});
                    }
                }
            }
            dis++;
        }
        return matrix;
    }
}