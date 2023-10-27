// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class ZeroOneMatrix {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int [][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            Queue<int[]> q = new LinkedList<>();

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(mat[i][j] == 0){
                        q.add(new int[]{i, j});
                    }
                    else{
                        mat[i][j] = -1;
                    }
                }
            }

            int dist = 1;
            while(!q.isEmpty()){
                int size = q.size();
                for(int k = 0; k< size; k++){
                    int [] popped = q.poll();

                    for(int[] dir : dirs){
                        int nr = popped[0] + dir[0];
                        int nc = popped[1] + dir[1];

                        if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                            mat[nr][nc] = dist;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
                dist++;
            }

            return mat;
        }
    }
}
