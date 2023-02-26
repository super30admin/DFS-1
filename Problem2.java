import java.util.LinkedList;
import java.util.Queue;
/*
01 matrix
approach: BFS, add all zeroes to queue initally, do bfs, when we find 1, we add to queue, update it's distance. do dist++ for every level finished in case of level traversal.
time: O(mxn)
space: O(mxn)
 */
public class Problem2 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m=mat.length, n = mat[0].length;
        for(int i= 0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j]==0) q.add(new int[]{i,j});
                else
                    mat[i][j] = -1;
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int nr = dir[0]+curr[0];
                int nc = dir[1] + curr[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1) {
                    mat[nr][nc] = mat[curr[0]][curr[1]]+1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return mat;
    }
}
