// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int[][] updateMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] = Integer.MAX_VALUE;

                else
                    q.add(new int[] { i, j });
            }

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int[] d : dir) {
                int i = p[0] + d[0];
                int j = p[1] + d[1];

                if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length
                        && matrix[p[0]][p[1]] + 1 < matrix[i][j]) {

                    matrix[i][j] = matrix[p[0]][p[1]] + 1;

                    q.add(new int[] { i, j });
                }
            }

        }

        return matrix;

    }
}