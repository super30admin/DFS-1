// Time Complexity O(m x n)
// Space Complexity Min (m x n)
// Runs on LeetCode YES

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Integer> qRow = new LinkedList<Integer>();
        Queue<Integer> qCol = new LinkedList<Integer>();
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    qRow.add(i);
                    qCol.add(j);
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int level = 1;

        while (!qRow.isEmpty()) {
            int size = qRow.size();

            for (int i = 0; i < size; i++) {
                int curRow = qRow.poll();
                int curCol = qCol.poll();

                for (int[] dir : dirs) {
                    int r = curRow + dir[0];
                    int c = curCol + dir[1];

                    if (r < mat.length && c < mat[0].length &&
                            r >= 0 && c >= 0 &&
                            mat[r][c] == -1) {
                        qRow.add(r);
                        qCol.add(c);
                        mat[r][c] = level;
                    }
                }
            }
            level++;
        }

        return mat;
    }
}