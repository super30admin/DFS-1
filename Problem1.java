// Time Complexity :  O(m * n) where m is the number of rows and n is the number of columns.
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// This code updates the distance of each non-zero
// element in the matrix to its nearest zero element using BFS traversal.

class Problem1 {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) {
            return mat;
        }
        int m, n;
        m = mat.length;
        n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[] {i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] d : dir) {
                    int r = d[0] + curr[0];
                    int c = d[1] + curr[1];
                    if(r >= 0 && c >=0 && r < m && c < n && mat[r][c] == -1) {
                        q.add(new int[] {r, c});
                        mat[r][c] = dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}