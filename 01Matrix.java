
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

public class 01Matrix {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        updateMatrix(mat);
    }


    public static int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)
            return mat;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        int m = mat.length;
        int n = mat[0].length;
        int distance = 1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc] == -1){
                        mat[nr][nc] = distance;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            distance++;
        }

        return mat;
    }
}

