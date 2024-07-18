// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 0)
                    q.add(new int[] { i, j });

        if (q.size() == m * n)
            return mat;
        System.out.println(q.size());
        int nearest = 2;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                mat[r][c] = nearest;
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == 1) {
                        mat[nr][nc] = nearest + 1;
                        q.add(new int[] { nr, nc });
                    }
                }

            }
            nearest++;
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] -= 2;
        return mat;
    }
}