Time Complexity: O(mn)
Space Complexity: O(mn)
Ran successfully on leetcode?: yes

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0)
                    q.add(new int[]{i, j});
                else
                    matrix[i][j] = -1;
            }
        }
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1){
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }
        
        return matrix;
    }
}
