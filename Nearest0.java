// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else if(mat[i][j]==1){
                    mat[i][j]=-1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] ind = q.poll();
            for(int[] dir : dirs){
                int nr = ind[0] + dir[0];
                int nc = ind[1] + dir[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1){
                    mat[nr][nc] = mat[ind[0]][ind[1]]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}