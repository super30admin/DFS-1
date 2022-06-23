class Solution {

    /**
     * distance of all zeros from zero is zero. Zeso is independant node - add them in queue.
     * Iterate over queue - BFS.
     * Mutate matrix with 1 to -1, so no confusion with current 1's.
     * using BFS look for 1's from each lwvel. Add 1 in each BFS level. Update input metrix with distance.
     * TC: O(mn)
     * SC: O(mn)
     */
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        if (mat == null || mat.length == 0) {
            return mat;
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == -1) {
                        q.add(new int[]{r, c});
                        mat[r][c] = dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}