class rottingOrangess {
    // TC: O(n) SC: O(n)
    public int orangesRotting(int[][] grid) {
        if (grid == null)
            return 0;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                else if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        if (fresh == 0)
            return 0;
        int time = 0;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        fresh--;
                        q.add(new int[] { r, c });
                    }
                }
            }
            time++;

        }
        if (fresh == 0)
            return time - 1;
        return -1;
    }
}
