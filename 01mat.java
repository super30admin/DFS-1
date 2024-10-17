class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Stack<int []> st = new Stack<>();
        int m = mat[0].length;
        int n = mat.length;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0)
                    st.push(new int[]{i,j});
                else
                    mat[i][j]=-1;
            }
        }

        while(!st.isEmpty()){
            int [] curr=st.pop();
            dfs(mat,curr[0],curr[1],1,m,n,dirs);
        }
        return mat;
    }
    private void dfs(int[][] mat, int i, int j, int depth, int m, int n, int[][] dirs){
        for(int[] dir:dirs){
            int nr = i+dir[0];
            int nc= j+dir[1];

            if(nr>=0 && nr<n && nc>=0 && nc<m && (mat[nr][nc]>depth ||mat[nr][nc]==-1)){
                mat[nr][nc]=depth;
                dfs(mat,nr,nc,depth+1,m,n,dirs);
            }
        }
    }
}
