// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int[][] floodFill(int[][] matrix, int sr, int sc, int newColor) {

        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        Queue<int[]> q = new LinkedList<>();
        int color = matrix[sr][sc];
        if (color == newColor)
            return matrix;
        matrix[sr][sc] = newColor;

        q.add(new int[] { sr, sc });

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int[] d : dir) {
                int i = p[0] + d[0];
                int j = p[1] + d[1];

                if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] == color) {

                    matrix[i][j] = newColor;

                    q.add(new int[] { i, j });
                }
            }

        }

        return matrix;

    }
}