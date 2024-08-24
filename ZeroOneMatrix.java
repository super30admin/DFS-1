//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] present =  queue.poll();
                for(int[] d : dirs) {
                    int r = present[0] + d[0];
                    int c = present[1] + d[1];
                    if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length&&mat[r][c]==-1) {
                        queue.add(new int[]{r,c});
                        mat[r][c] = 1 + mat[present[0]][present[1]];
                    }
                }
            }
        }

        return mat;
    }
}
