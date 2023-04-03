import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private static final int[][] DIRS = new int[][] {{0,-1}, {-1,0}, {1,0}, {0,1}};

    // Time Complexity : O(mn)
    // Space Complexity : O(mn)
    // Did this code successfully run on Leetcode : Yes
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null) {
            return null;
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] = -1;
                } else if (mat[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            System.out.println(size);

            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();

                for(int[] dir: DIRS) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] == -1) {
                        q.offer(new int[] {nr, nc});
                        mat[nr][nc] = dist;
                    }
                }
            }

            dist += 1;
        }

        return mat;
    }
}