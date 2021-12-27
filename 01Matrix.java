// Time Complexity : O(m*n)
// Space Complexity : O(m*n) for the queue
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// BFS approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int lvl=0;

        if (mat == null || mat[0] == null) {
            return new int[m][n];
        }

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        // Queue of the type int[] {x-coordinate ,y-coordinate}
        Queue<int[]> q = new LinkedList<>();

        // We will start by adding 0 valued co-ordinates to the queue since it is the independent value out of the two values
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
                else if (mat[i][j] == 1) {      // marking all 1 as -1 initially to avoid re-updation of the cell, this will prevent using a different array for keeping track of visited cells
                    mat[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            lvl++;
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] node = q.poll();

                for (int[] dir: dirs) {
                    int nr = dir[0] + node[0];
                    int nc = dir[1] + node[1];
                    if (nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc] == -1) {
                        mat[nr][nc] = lvl;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return mat;
    }
}