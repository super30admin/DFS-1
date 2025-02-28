// Approach: This problem involves calculating the shortest distance from multiple sources, making it well-suited for BFS. Since BFS ensures
// that all neighbors at the current level are explored before moving to the next level, it guarantees that the shortest distance is computed
// first for each encountered unvisited cell. Initialize a distance matrix with 0s for all cells containing 0 in the given matrix and -1 for
// unvisited cells. Add the row and column indices of all encountered 0s to a queue for BFS. For each unvisited neighbor of the current cell
// in BFS, update the distance as the current cell's distance + 1 and add it to the queue. Repeat this process while the queue has more
// elements. Finally, return the distance matrix.
// Time Complexity: O(m * n) where m - #rows, n - #cols
// Space Complexity: O(m * n) where m - #rows, n - #cols

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/01-matrix/description/

import java.util.Deque;
import java.util.ArrayDeque;

public class BinaryMatrixNearestZero {

    int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Deque<int[]> Q = new ArrayDeque<>();
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    Q.add(new int[] { i, j });
                } else {
                    distance[i][j] = -1;
                }
            }
        }
        int[] rowN = { -1, 0, 1, 0 };
        int[] colN = { 0, 1, 0, -1 };
        while (!Q.isEmpty()) {
            int[] cell = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cell[0] + rowN[i], nc = cell[1] + colN[i];
                if (isSafe(mat, nr, nc) && distance[nr][nc] == -1) {
                    distance[nr][nc] = distance[cell[0]][cell[1]] + 1;
                    Q.add(new int[] { nr, nc });
                }
            }
        }
        return distance;
    }

    boolean isSafe(int[][] mat, int i, int j) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat[0].length;
    }

    public static void main(String[] args) {
        BinaryMatrixNearestZero bmnz = new BinaryMatrixNearestZero();
        // Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
        // Output: [[0,0,0],[0,1,0],[1,2,1]]
        int[][] mat = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };
        mat = bmnz.updateMatrix(mat);
        for (int[] row: mat) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + " ");
            }
            System.out.println();
        }
    }
}