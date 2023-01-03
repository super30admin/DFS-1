import java.util.*;

public class ZeroOne_Matrix_BFS {

    // Approach: BFS: starts with all 0 elements in the Queue and change others to -1.
    // Add distance by one on every batch in queue.
    // Time: O(r.c) since BFS in worst case takes all the elements in the queue, Space: O(r.c) - size of queue in worst case
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dirs[][] = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> q = new LinkedList();

        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[] {i,j});
                }
                else {
                    matrix[i][j] = -1;
                }
            }
        }

        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i<size; i++) {
                int curr[] = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >=0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] == -1) {
                        matrix[nr][nc] = dist;
                        q.add(new int[] {nr,nc});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}