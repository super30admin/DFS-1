// Time Complexity o(n*m) Space complexity o(n*m)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 1;
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc] == -1) {
                        q.add(new int[]{nr, nc});
                        mat[nr][nc] = dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}

