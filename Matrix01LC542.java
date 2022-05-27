import java.util.*;

//Time Complexity :O(NM)   Optimized BFS
//Space COmplexity: O(NM)
//LeetCode : Yes
public class Matrix01LC542 {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {

            int m = mat.length;
            int n = mat[0].length;
            Queue<int []> q = new LinkedList<>();
            int [][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //Put all 0's in the queue..same as no dependecy compoennts goes into the queue and we process them at the same level
                    if (mat[i][j] == 0) {
                        q.add(new int[] {i, j});
                    } else {
                        //change to -1 so we know which one is visited and which is not. We check this condition later
                        mat[i][j] = -1;
                    }
                }
            }
            int dist = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] cell = q.poll();
                    for (int[] d : dir) {
                        int nr = cell[0] + d[0];
                        int nc = cell[1] + d[1];
                        if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
                            mat[nr][nc] = dist + 1;
                            q.add(new int[] {nr, nc});
                        }
                    }
                }
                dist++;
            }
            return mat;
        }
    }
}
