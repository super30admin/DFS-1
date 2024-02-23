import java.util.LinkedList;
import java.util.Queue;

// TC - O(MN * MN)
// SC - O(MN)

public class NearestZeroDistanceBFS {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 1) { // Start a BFS from each 1 to find 0
                        boolean foundZero = false;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[] { i, j });
                        int level = 1;
                        while (!queue.isEmpty()) {
                            int size = queue.size();
                            for (int k = 0; k < size; k++) {
                                int[] currCell = queue.poll();
                                int row = currCell[0];
                                int col = currCell[1];
                                for (int[] dir : dirs) {
                                    int currRow = row + dir[0];
                                    int currCol = col + dir[1];
                                    if (currRow >= 0 && currRow < mat.length && currCol >= 0
                                            && currCol < mat[0].length) {
                                        if (mat[currRow][currCol] == 0) { // 0 is found
                                            mat[i][j] = level; // Set cell having 1 = Number of levels away from a 1
                                            foundZero = true;
                                            break;
                                        }
                                        queue.add(new int[] { currRow, currCol }); // Maintain size of level ANYWAY
                                    }
                                }
                                if (foundZero) {
                                    break;
                                }
                            }
                            level++;
                            if (foundZero) {
                                break;
                            }
                        }
                    }
                }
            }

            return mat;
        }
    }
}
