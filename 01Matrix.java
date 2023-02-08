// Time Complexity : O(mn)
// Space Complexity : O(mn)

class Solution {
    int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat[0].length;
        int n = mat.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                else if(mat[i][j]==1)
                    mat[i][j]=-1;
            }
        while(!q.isEmpty()){
            int temp[] = q.poll();
            int r = temp[0];
            int c = temp[1];
            for(int[] dir:dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && mat[nr][nc]==-1){
                    q.add(new int[]{nr,nc});
                    mat[nr][nc] = mat[r][c] +1;
                }
            }
        }
        return mat;
    }
}