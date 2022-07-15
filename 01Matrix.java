import java.util.*;

// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // null
        if (mat == null || mat.length == 0)
            return new int[0][0];
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    q.add(new int[] { i, j });
            }
        }
        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cors = q.poll();
                for (int[] dir : dirs) {
                    int r = cors[0] + dir[0];
                    int c = cors[1] + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == 1 && !visited[r][c]) {
                        q.add(new int[] { r, c });
                        mat[r][c] = count;
                        visited[r][c] = true;
                    }
                }
            }
            count++;
        }
        return mat;
    }
}