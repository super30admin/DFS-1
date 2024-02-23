// Time Complexity :  O(M*N)
// Space Complexity :  O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// BFS, TC = O(M * N), SC = O(M * N)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // null
        if(mat == null || mat.length == 0) return mat;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) q.add(new int[]{i, j});
                else mat[i][j] = -1; // replace 1 with -1, to keep track of all 1s as leter its replaced with distance, taking -1 as dist can be 1, so to remove confusion
            }
        }
        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            // level processing and then increase the distance
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] dir: dirs) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    // bounds check
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
                        mat[nr][nc] = dist; // assign the distance
                        q.add(new int[]{nr, nc}); // add it to the q as we are doing BFS for all nodes & dist is keeping track of it
                    }
                }
            }
            dist++; // increase the distance after level processing
        }
        return mat;
    }
}