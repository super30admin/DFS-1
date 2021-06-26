package DFS1;

import java.util.LinkedList;
import java.util.Queue;

public class question65_01Matrix {
    /* Created by palak on 6/26/2021 */

    /*
            In this problem BFS must be prefereed. It is because we will find a 0 soon and and thus the calculation will be accurate.
            a) BFS
            b) Optimized BFS

            Time Complexity: O(m * n)
            Space Complexity: O(m * n)
    */

    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;

        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();

        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(mat[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int dirs[][] = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int distance = 1;
        while(!row.isEmpty()) {
            int size = row.size();
            for(int i = 0 ; i < size ; i++) {
                int currRow = row.poll();
                int currCol = col.poll();
                for(int[] dir: dirs) {
                    int nr = currRow + dir[0];
                    int nc = currCol + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
                        row.add(nr);
                        col.add(nc);
                        mat[nr][nc] = distance;
                    }
                }
            }
            distance++;
        }
        return mat;
    }

    public static void main(String[] args) {

    }
}
