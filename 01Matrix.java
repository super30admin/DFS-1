// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] mat) {
         if(mat == null || mat.length == 0 ) return mat;
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i =0; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0 ; i< size ; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && mat[nr][nc] == -1){
                        q.add(new int[] {nr,nc});
                        mat[nr][nc] = dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
