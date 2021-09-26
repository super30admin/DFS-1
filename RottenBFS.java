
/**
 * Time complexity is m x n (rows x columns)
 * Space complexity is ~ m x n (rows x columns)
 */
import java.util.*;

public class RottenBFS {
    class Solution {
        public int orangesRotting(int[][] grid) {
            if (grid == null)
                return 0;

            // var declarations
            int fresh = 0;
            Queue<int[]> qu = new LinkedList<>();
            int m = grid.length;
            int n = grid[0].length;

            // traversing to find all the rotten cells
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        qu.add(new int[] { i, j });
                    }
                    if (grid[i][j] == 1)
                        fresh++;
                }
            }

            System.out.println(fresh);
            if (fresh == 0)
                return 0;

            int[][] arr = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            int timeTaken = 0;
            // roting the cells
            while (!qu.isEmpty()) {
                int size = qu.size();
                for (int k = 0; k < size; k++) {
                    int[] temp = qu.poll();
                    for (int i = 0; i < arr.length; i++) {
                        int r = temp[0] + arr[i][0];
                        int c = temp[1] + arr[i][1];
                        if ((r > -1 && r < m) && (c > -1 && c < n)) {
                            if (grid[r][c] == 1) {
                                grid[r][c] = 2;
                                qu.add(new int[] { r, c });
                                fresh--;
                            }
                        }
                    }
                }
                timeTaken++;
            }
            if (fresh == 0)
                return --timeTaken;
            else
                return -1;
        }
    }
}
