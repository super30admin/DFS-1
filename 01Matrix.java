// Time Complexity : o (m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    // using BFS
    public int[][] updateMatrix(int[][] mat) {

        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m = mat.length;
        int n = mat[0].length;
        // BFS initilizations
        Queue<int[]> queue = new LinkedList<>();
        int distance = 1;

        // mark all the ones to 2 or a value that is not 1
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                } else if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }


        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir: dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >=0 && nc >= 0 && nr <m && nc <n && mat[nr][nc] == -1) {
                        mat[nr][nc] = distance;
                        queue.add(new int[] {nr, nc});
                    }
                }
            }
            distance++;
        }

        return mat;
    }
}
