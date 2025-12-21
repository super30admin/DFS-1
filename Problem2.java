// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We perform a multi-source BFS by first adding all cells with value 0 into the queue,
   and marking all 1-cells as -1 to represent “unvisited / distance not assigned yet”.
BFS expands level-by-level from all zeros simultaneously. Each BFS level represents
   distance from the nearest 0, so when we reach an unvisited (-1) neighbor, we set its
   distance and push it into the queue.
Since every cell is visited and assigned a distance at most once, and each visit checks
   4 directions, the algorithm runs in O(m*n) time and uses O(m*n) space in the worst case.
*/
*/

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<mat.length;i++) {
            for(int j = 0;j<mat[0].length;j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int dist = 0;
        while(!q.isEmpty()) {
            dist++;
            int size = q.size();
            for(int i = 0;i<size;i++) {
                int[] curr = q.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                for(int[] dir : dirs) {
                    int nr = currRow + dir[0];
                    int nc = currCol + dir[1];
                    if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] == -1) {
                        mat[nr][nc] = dist;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return mat;
    }
}