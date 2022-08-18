// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        if(mat == null || mat.length == 0) return mat;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
         
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
                else {
                    q.add(new int[]{i, j});
                }
            }
        }
        if(q.size() == m*n || q.size() == 0) return mat;
        //int dist = 0;
        while(!q.isEmpty()) {
            //int size = q.size();
            //for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] dir: dirs) {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1) {
                        q.add(new int[]{r, c});
                        mat[r][c] = mat[curr[0]][curr[1]] + 1;
                    }
                }
            //}
            //dist++;
        }
        return mat;
    }
}