//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class ZeroOneMatrix {
    int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                } else {
                    q.offer(new int[] { i, j });
                }
            }
        }

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for (int i = 0; i < dir.length; i++) {
                    int newX = x + dir[i][0];
                    int newY = y + dir[i][1];
                    if (newX >= 0 && newY >= 0 && newX < mat.length && newY < mat[0].length && mat[newX][newY] == -1) {

                        q.offer(new int[] { newX, newY });
                        mat[newX][newY] = level;
                    }
                }
            }
            level++;
        }
        return mat;
    }
}
