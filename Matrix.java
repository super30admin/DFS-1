// Time Complexity :O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Figure out the value of matrix to be updated as mat[curr[0]][curr[1]]+1


// Your code here along with comments explaining your approach

class Matrix {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> q = new LinkedList();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j]= -1;
                }
            }
        }
      
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                //bounds check
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    
                    if(mat[nr][nc]==-1){
                        q.add(new int[]{nr,nc});
                        mat[nr][nc] = mat[curr[0]][curr[1]]+1;
                    }
                }
               
            }
            
        }
        return mat;

    }
}