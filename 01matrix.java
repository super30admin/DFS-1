// Time Complexity : O(m x n)
// Space Complexity : O( m x n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0){
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // U D L R
        for(int i = 0; i < m; i++){
            for( int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add( new int[] {i,j}); // adding 0's to the queue
                }else{
                    mat[i][j] = -1; // converting 1's to -1
                }
            }
        }
        int lvl = 0; // initializing level to 0, will use to change mat matrix
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr < m && nc < n && nr >= 0 && nc >= 0 && mat[nr][nc] == -1){
                        q.add(new int[] {nr,nc});
                        mat[nr][nc] = 1 + lvl;
                    }
                }
            }
            lvl++;
        }
        return mat;

    }
}