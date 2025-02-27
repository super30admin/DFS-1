// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                }else {
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            for(int[] dir: dirs) {
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
                    q.add(new int[] {nr, nc});
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                }
            }
        }
        return mat;
    }
}