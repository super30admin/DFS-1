//https://leetcode.com/problems/01-matrix/solutions/3920110/94-87-multi-source-bfs-queue
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int maxVal = m * n;
        int[][] directions ={{1,0},{-1,0},{0,1},{0,-1}}; 
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0)
                    q.offer(new int[]{i,j});
                else
                    mat[i][j] = maxVal;
            }
        }
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[] dir : directions){
                int r = cell[0] + dir[0];
                int c = cell[1] + dir[1];
                if(r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[cell[0]][cell[1]] + 1 ){
                    q.offer(new int[]{r,c});
                    mat[r][c] = mat[cell[0]][cell[1]] + 1;
                }
                    
            }

        }
        return mat;
    }
}