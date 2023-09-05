import java.util.LinkedList;
import java.util.Queue;

public class Sample {

    public static void main(String[] args) {

        int[][] mat = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };
        Sample obj = new Sample();
        int[][] obj1 = obj.zeroMatrix(mat);

    
        for (int i = 0; i < obj1.length; i++) {
            for (int j = 0; j < obj1[0].length; j++) {
                System.out.print(obj1[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] zeroMatrix(int[][] matrix) {
        // null case
        if (matrix == null || matrix.length == 0) return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = -1;
                } else {
                    q.add(new int[]{i, j});
                }
            }
        }
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cr = q.poll();
                for (int[] dir : dirs) {
                    int nr = cr[0] + dir[0];
                    int nc = cr[1] + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1) {
                        matrix[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}
