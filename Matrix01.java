import java.util.LinkedList;
import java.util.Queue;

//Time - O(n), Space - O(n)
public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;

        Queue<int[]> q = new LinkedList<>();
        int lvl = 1;
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] arr = q.poll();
                for(int[] dir : dirs) {
                    int nr = arr[0] + dir[0];
                    int nc = arr[1] + dir[1];
                    if(nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length && mat[nr][nc] == 1) {
                        mat[nr][nc] = lvl * (-1);
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            lvl++;
        }

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] < 0) {
                    mat[i][j] = (-1) * mat[i][j];
                }
            }
        }

        return mat;
    }
}