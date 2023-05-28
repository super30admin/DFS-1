// Time Complexity : O(mn)
// Space Complexity : O(mn) (for the Queue)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) {
            return mat;
        }

        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // UDLR

        // initially add all "independent" nodes in graph
        // basically that is all the 0's in this problem
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[] {i,j});
                } else { 
                    // otherwise, convert 1's to -1 to mark them
                    // as "unvisited"
                    mat[i][j] *= -1;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] c = q.poll();
            for(int[] d : dirs) {
                int nr = c[0] + d[0];
                int nc = c[1] + d[1];

                // if the cell is still unvisited, update its value and put it in Q
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] < 0) {
                    mat[nr][nc] = mat[c[0]][c[1]] + 1;
                    q.add(new int[] {nr, nc});
                }
            }
        }

        return mat;
    }
}