// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using BFS approach, 
 * Use queue to keep track of the row and col of the matrix and check if the current color is equal to 0 , we add all the indexes in the queue.
 * just go through the next values and increment current value by previous +1, run till queue is not empty
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0)
            return mat;
        int m = mat.length, n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
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
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                        queue.add(new int[] { nr, nc });
                    }
                }

            }
        }

        return mat;
    }
}