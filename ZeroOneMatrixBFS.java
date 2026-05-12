// Time Complexity : O(m * n) where m is number of rows and n is number of columns in the matrix. We are processing each cell at most once.
// Space Complexity :  o(m * n) for the queue in worst case when all cells are 0s and we are adding all cells to the queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// BFS approach
// 1. Put all 0s into queue and mark 1s as unvisited
// 2. Start BFS from all 0s and update distance for unvisited 1s
// 3. Return the matrix after processing all 0s
//  Note: This approach is optimal as we are doing BFS from all 0s and updating distance for unvisited 1s. Hence, it will not lead to time out exception for large matrices.
import java.util.*;

class ZeroOneMatrixBFS {

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] directions = new int[][]
        {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        Queue<int[]> que = new LinkedList<>();

        // Put all 0s into queue
        // Mark 1s as unvisited (-1)
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    que.offer(new int[] { i, j });
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        int dist = 1;

        while (!que.isEmpty()) {

            int size = que.size();

            // Process one BFS level
            for (int i = 0; i < size; i++) {

                int[] curr = que.poll();

                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) {

                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        mat[nr][nc] == -1) {

                        mat[nr][nc] = dist;

                        que.offer(new int[] { nr, nc });
                    }
                }
            }

            dist++;
        }

        return mat;
    }
}