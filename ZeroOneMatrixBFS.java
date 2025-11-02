import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode: https://leetcode.com/problems/01-matrix/
 *
 * Approach:
 * This class provides three BFS-based solutions to the 01 Matrix problem, where each cell in the matrix is updated with the distance to the nearest 0.
 *
 * 1. updateMatrix: Multi-source BFS. All 0s are enqueued and all 1s are set to -1. BFS expands from all 0s, updating distances for -1 cells layer by layer.
 * 2. updateMatrix2: Similar to updateMatrix, but updates each cell's distance based on its neighbor's value, ensuring shortest path propagation.
 * 3. updateMatrix3: For each 1, performs a BFS to find the nearest 0. This is less efficient but demonstrates the brute-force BFS approach.
 *
 * Time Complexity:
 * - updateMatrix & updateMatrix2: O(m * n), where m is the number of rows and n is the number of columns. Each cell is visited at most once.
 * - updateMatrix3: O((m * n)^2) in the worst case, as a BFS is performed from every 1 cell.
 *
 * Space Complexity:
 * - updateMatrix & updateMatrix2: O(m * n) for the queue in the worst case.
 * - updateMatrix3: O(m * n) for the visited array and queue during each BFS.
 */
public class ZeroOneMatrixBFS {
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        int rLength = mat.length;
        int cLength = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rLength; i++) {
            for (int j = 0; j < cLength; j++) {
                if (mat[i][j] == 0) queue.add(new int[]{i, j});
                else mat[i][j] = -1;
            }
        }
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] dir : dirs) {
                    int r = current[0] + dir[0];
                    int c = current[1] + dir[1];
                    if (c >= 0 && r >= 0 && c < cLength && r < rLength && mat[r][c] == -1) {
                        mat[r][c] = dist;
                        queue.add(new int[]{r, c});
                    }
                }
            }
            dist++;
        }
        return mat;
    }

    public int[][] updateMatrix2(int[][] mat) {
        int rLength = mat.length;
        int cLength = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rLength; i++) {
            for (int j = 0; j < cLength; j++) {
                if (mat[i][j] == 0) queue.add(new int[]{i, j});
                else mat[i][j] = -1;
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : dirs) {
                int r = current[0] + dir[0];
                int c = current[1] + dir[1];
                if (c >= 0 && r >= 0 && c < cLength && r < rLength && mat[r][c] == -1) {
                    mat[r][c] = mat[current[0]][current[1]] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        }

        return mat;
    }

    public int[][] updateMatrix3(int[][] mat) {
        int rLength = mat.length;
        int cLength = mat[0].length;
        boolean[][] visited;
        for (int i = 0; i < rLength; i++) {
            for (int j = 0; j < cLength; j++) {
                Queue<int[]> queue = new LinkedList<>();
                if (mat[i][j] == 1) {
                    visited = new boolean[rLength][cLength];
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    int dist = 0;
                    boolean foundZero = false;
                    while (!queue.isEmpty() && !foundZero) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] current = queue.poll();
                            if (mat[current[0]][current[1]] == 0){
                                foundZero = true;
                                break;
                            }
                            for (int[] dir : dirs) {
                                int r = current[0] + dir[0];
                                int c = current[1] + dir[1];
                                if (c >= 0 && r >= 0 && c < cLength && r < rLength && !visited[r][c]) {
                                    queue.add(new int[]{r, c});
                                    visited[r][c] = true;
                                }
                            }
                        }
                        dist++;
                    }
                    mat[i][j] = dist-1;
                }
            }
        }
        return  mat;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new ZeroOneMatrixBFS().updateMatrix3(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
}
