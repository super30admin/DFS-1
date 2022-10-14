class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // T.C : O(m * n)
        // S.C : O(m * n)
        // Executed
        if (mat == null || mat.length == 0)
            return mat;
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
                else if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }
        
        int distance = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                        mat[nr][nc] = distance;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            distance++;
        }
        return mat;
    }
}