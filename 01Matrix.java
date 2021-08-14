// TC: O((m x n)^2)
// SC: O(m x n)

class Solution {
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
        int [][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int [] curr = q.poll();
                for(int[] d : dirs) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    if(r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1) {
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