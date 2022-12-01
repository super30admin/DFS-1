import java.util.LinkedList;
import java.util.Queue;

/**
 * TC - O(m * n) - m - mat row count, n - mat column count
 * SC - O(m * n) - m - mat row count, n - mat column count
 */
public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}}; // U D L R

        Queue<int[]> queue = new LinkedList<>();
        int oneCounts = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[] {i,j});
                } else {
                    mat[i][j] = -1;
                    oneCounts++;
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                if (oneCounts != 0) {
                    for (int[] dir: dirs) {
                        int newRow = cell[0] + dir[0];
                        int newCol = cell[1] + dir[1];

                        if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && mat[newRow][newCol] == -1) {
                            mat[newRow][newCol] = mat[cell[0]][cell[1]] + 1;
                            queue.add(new int[]{newRow, newCol});
                            oneCounts--;
                        }
                    }
                }
            }
        }

        return mat;
    }
}
