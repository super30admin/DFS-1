// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, in bfs solution, forgot to add children to queue

// in bfs solution, if mat[i][j] == 0, add to queue, else make it -1
// while iterating over queue, check all 4 neighbours of current cell and distance of neighbour cell
// is distance at current cell + 1
// then add all neighbours to queue

import java.util.Queue;

public class prob2 {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length; int n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) q.add(new int[]{i, j});
                else mat[i][j] *= -1;
            }
        }

        int[][] dirs = {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return mat;
    }
    
}
