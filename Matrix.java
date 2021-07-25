import java.util.*;

public class Matrix {

    //TC: Traversing all the nodes.
    //SC: O(MN) - Using queue at the worst cast(Alll zeros) it will have all the values
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0)
            return mat;
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : dirs) {
                int row = dir[0] + current[0];
                int column = dir[1] + current[1];

                if (row >= 0 && row < m && column >= 0 && column < n
                        && mat[row][column] > mat[current[0]][current[1]] + 1) {
                    mat[row][column] = mat[current[0]][current[1]] + 1;
                    queue.add(new int[] { row, column });
                }
            }
        }
        return mat;

    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] result = matrix.updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, });
        System.out.println("The result: " + result);
    }

}
