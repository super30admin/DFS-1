// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * BFS. Mark all 1 as -1 initially (later it will be updated with the distance which can be 1. so to differentiate with this 1 mark it -1
 * initially)
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;

        //O(m*n)
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0)
                    q.add(new int[]{i,j});
                else if(mat[i][j] == 1)
                    mat[i][j] = -1;
            }
        }

        //O(m*n)
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            for(int[] dir: dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];

                if(row>=0 && col>=0 && row<m && col<n && mat[row][col] == -1) {
                    mat[row][col] = mat[curr[0]][curr[1]] + 1;
                    q.add(new int[]{row, col});
                }
            }
        }

        return mat;
    }
}