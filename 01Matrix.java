// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// BFS - startinbg with 0 -> getting with neighbors 
// for r in for c in updating martix with nearest dist
class Solution {
    int[][]dirs= {{1,0},{0,1},{0,-1},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        Queue <int []> q =new LinkedList<>();
        int[][]dirs= {{1,0},{0,1},{0,-1},{-1,0}};
        for(int i=0;i<mat.length;i++){
            for(int j=0; j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else if(mat[i][j]==1){
                    mat[i][j]=-1; //changing all 1 to -1 
                }
            }
            }
            
            while(!q.isEmpty()){
                int []curr=q.poll();
                for(int i=0;i<dirs.length;i++){
                    int targetRow=curr[0]+dirs[i][0];
                    int targetCol=curr[1]+dirs[i][1];

                    if(targetRow>=0 && targetRow<mat.length && targetCol>=0 && 
                     targetCol < mat[0].length && mat[targetRow][targetCol]==-1){
                        mat[targetRow][targetCol]=mat[curr[0]][curr[1]]+1; //changes according to the level
                        q.add(new int[] {targetRow, targetCol});
                         
                     }
               }
            }

            return mat;
    }
}



// Time Complexity : O((mn)^2)
// Space Complexity : O((mn)^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Using DFS
//Time Limit Exceeded

class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0 ) return mat;
        Queue <int []> q =new LinkedList<>();
        int m = mat.length;
        int n= mat[0].length;
        int[][]dirs= {{0,1},{0,-1},{-1,0},{1,0}};
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(mat[i][j]==1){
                    mat[i][j]=-1;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(mat[i][j]==0){
                    dfs(mat, i ,j, 0 ,dirs, m ,n);
                }
            }
        }
        return mat;
    }


    private void dfs(int[][] matrix, int r, int c, int dist, int[][] dirs, int m ,int n){
        //base
        if( r<0 || c<0 || r==m || c==n) return;

        if(matrix[r][c] !=-1 && matrix[r][c]<dist) return;


        //logic
        matrix[r][c] = dist;
        for (int[] dir: dirs){
            int nr = r+ dir[0];
            int nc = c+ dir[1];
            dfs(matrix , nr, nc , dist+1,dirs, m ,n);
        }
    }
}
