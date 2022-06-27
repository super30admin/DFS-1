public class FloodFill {
    // TC is O(m*n)
    // SC is min(m,n)
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int m = mat.length;
        int n = mat[0].length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(i);
                    q.add(j);
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size() / 2;

            for (int i = 0; i < size; i++) {
                int r = q.poll();
                int c = q.poll();
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                        if (mat[nr][nc] == -1) {
                            mat[nr][nc] = dist + 1;
                            q.add(nr);
                            q.add(nc);
                        }

                    }
                }
            }
            dist++;
        }
        return mat;
    }
}