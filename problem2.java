class Solution {
    //time-O(r.c) - #rows, #cols
    //space- O(r.c)- #rows, #cols
    public int[][] updateMatrix(int[][] mat) {
    if (mat == null || mat.length == 0) {
        return new int[0][0];
    }

    int m = mat.length;
    int n = mat[0].length;
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    Queue<int[]> queue = new LinkedList<int[]>();

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (mat[i][j] == 0) {
                queue.add(new int[] { i, j });
            } else {
                mat[i][j] = -1;
            }
        }
    }

    while (!queue.isEmpty()) {
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            int[] pair = queue.poll();
            for (int[] dir : dirs) {
                int r = pair[0] + dir[0];
                int c = pair[1] + dir[1];

                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1) {
                    mat[r][c] = mat[pair[0]][pair[1]] + 1;
                    queue.add(new int[] { r, c });
                }
            }
        }

    }
    return mat;
}
}