// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }
        int m = mat.length, n = mat[0].length;
        Queue<int[]> bfsQueue = new LinkedList<>();
        int[][] directions = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    bfsQueue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = bfsQueue.poll();
                for (int[] direction : directions) {
                    int dirRow = curr[0] + direction[0];
                    int dirCol = curr[1] + direction[1];
                    if (dirRow >= 0 && dirCol >= 0 && dirRow < m && dirCol < n && mat[dirRow][dirCol] == -1) {
                        mat[dirRow][dirCol] = mat[curr[0]][curr[1]] + 1;
                        bfsQueue.add(new int[]{dirRow, dirCol});
                    }
                }

            }
        }
        return mat;
    }
}