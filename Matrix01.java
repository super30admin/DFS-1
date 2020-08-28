// Time Complexity : O (N*M) N * M is the dimension of the grid.
// Space Complexity : O (N*M) N * M is the dimension of the grid.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// For each cell in the matrix we have to find distance to nearest zero and store it in existing matrix. To not confuse the distance 1 and
// the actual cell value 1 as same, we will initially make all 1 values as -1. Then we can keep all the cells( i, j pair) in the queue that have value
// 1, the add its neighbours to the queue and increment the distance value by 1. For these neighbor locations in matrix can be replaced with distance value.
// We can keep doing the same for next level of neighbor cells and increment the distance by 1 at each level. In the end,
// we will obtain a matrix where the actual values would have been replaced by distance value, distance to the nearest zero.

import java.util.Queue;
import java.util.LinkedList;

public class Matrix01 {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return matrix;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        getNearestZeroDistance(matrix, queue);
        return matrix;
    }

    int getNearestZeroDistance(int[][] matrix, Queue<int[]> queue) {
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (isInRange(matrix, r, c) && matrix[r][c] == -1) {
                        matrix[r][c] = level;
                        queue.add(new int[]{r, c});
                    }
                }
                size--;
            }
            level++;
        }

        return level;
    }

    private boolean isInRange(int[][] matrix, int r, int c) {
        return r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length;
    }

}
