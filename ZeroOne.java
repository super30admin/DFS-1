// Time Complexity : O(MXN)
// Space Complexity : O(MXN)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;
        
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    mat[i][j] = -1;
                }
                else {
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] dir:dirs){
                int nr = dir[0] + cur[0];
                int nc = dir[1] + cur[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                    q.add(new int[]{nr,nc});
                    mat[nr][nc] = mat[cur[0]][cur[1]] + 1;
                }
            }
        }
        return mat;
    }
}