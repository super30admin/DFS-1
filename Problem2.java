// https://leetcode.com/problems/01-matrix/
// Time Complexity : O(m * n) where m is the number of rows and n is the number of columns in the matrix.
// Space Complexity : O(m * n) in the worst case, due to the queue used for the breadth-first search.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {{-1,0}, {0,-1}, {0, 1}, {1,0}};
        Queue<int[]> q =new LinkedList<>();
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] *= -1;
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if(r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1){
                    q.add(new int[]{r,c});
                    mat[r][c] = mat[curr[0]][curr[1]] + 1;
                }
            }
        }
        return mat;
    }
}