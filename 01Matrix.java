// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int [][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    if( nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1){
                        q.add(new int[]{nr, nc});
                        mat[nr][nc]=dist+1;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}