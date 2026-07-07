import java.util.*;

class Solution {
    /* 
        TC - O(m * n)
        SC - O(m * n)
        All 0s are added to the queue first because their distance to the nearest 0 is already 0.
        From these 0s, BFS spreads outward one layer at a time. Whenever it reaches an unvisited 1 (marked as -1), 
        it sets its distance to the current cell's distance + 1 and adds it to the queue. 
        Since BFS always visits cells in increasing order of distance, the first time a cell is reached is guaranteed to be its shortest distance to a 0.
    */
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        for (int  i = 0; i < mat.length; i++) {
            for (int  j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i< size; i++) {
                int[] curr = q.poll();

                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] == -1) {
                        q.add(new int[]{nr, nc});
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1;

                    }
                }
            }
            
        }

        return mat;
    }
}