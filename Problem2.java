// Time Complexity : O(m*n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                if(mat[i][j]==1)
                    mat[i][j]=-1;
            }
        }
        int visit = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr >= 0 && nr < m && nc>=0 && nc < n && mat[nr][nc]==-1){                    mat[nr][nc]=visit;
                    q.add(new int[]{nr,nc});

                    }
                }
            }
            visit++;
        }
        return mat;
    }
}