/* Time Complexity : O(m*n) 
 *  m - rows of the matrix - mat
 *  n - cols of the matrix - mat */
/* Space Complexity : O(m*n)
*  m - rows of the matrix - mat
*  n - cols of the matrix - mat */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//BSF solution

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};//right,left,down,up

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k ++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                        q.add(new int[]{nr,nc});
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    }
                }
            }
        }
        return mat;
    }
}