// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;
public class ZeroOneMatrix {
    static int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    que.add(i);
                    que.add(j);
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while(!que.isEmpty()) {
            int cr = que.poll();
            int cc = que.poll();
            for(int[] d : dir) {
                int nr = d[0] + cr;
                int nc = d[1] + cc;
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                    mat[nr][nc] = mat[cr][cc] + 1;
                    que.add(nr);
                    que.add(nc);
                }
            }

        }

        return mat;
    }

    public static void main(String[] args) {
        int[][]mat  = {{0,0,0}, {0,1,0}, {1,1,1}};
        System.out.println("Matrix:");
        for(int[] d: mat) {
            System.out.println(Arrays.toString(d));
        }

        int[][] res = updateMatrix(mat);
        System.out.println("Distance");
        for(int[] d: res) {
            System.out.println(Arrays.toString(d));
        }
    }
}
