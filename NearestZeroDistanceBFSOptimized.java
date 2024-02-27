import java.util.LinkedList;
import java.util.Queue;

// TC - O(MN)
// SC - O(MN)

public class NearestZeroDistanceBFSOptimized {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            Queue<int[]> queue = new LinkedList<>();
            int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 0) {
                        queue.add(new int[] { i, j });
                    } else {
                        mat[i][j] = -1;
                    }
                }
            }

            int level = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] currCell = queue.poll();
                    int row = currCell[0];
                    int col = currCell[1];
                    for (int[] dir : dirs) {
                        int currRow = row + dir[0];
                        int currCol = col + dir[1];
                        if (currRow >= 0 && currRow < mat.length && currCol >= 0 && currCol < mat[0].length) {
                            if (mat[currRow][currCol] == -1) { // 1 is found
                                mat[currRow][currCol] = level; // Number of levels away from a 0
                                queue.add(new int[] { currRow, currCol }); // Maintain size of level
                            }
                        }
                    }
                }
                level++;
            }
            return mat;
        }
    }
}
