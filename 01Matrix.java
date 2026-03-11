import java.util.*;

// BFS O(n * m) time, O(n * m) space
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dirs = new int[][] {
            {0,1},{1,0},{-1,0},{0,-1}
        };

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        int distance = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if (r >= 0 && c >= 0 && r < n && c < m && mat[r][c] == -1) {
                        q.offer(new int[] {r,c});
                        mat[r][c] = distance;
                    }
                }
                
            }
            distance++;
        }
        return mat;
    }
}
