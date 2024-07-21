// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    if(!areZero(mat,i,j)){
                        mat[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    helper(i,j,1,mat);
                }
            }
        }
        return mat;


    }

    public void helper(int i, int j, int val, int[][] mat){
        if(i<0 || j<0 || i>=mat.length || j>= mat[0].length) return;
        if(mat[i][j] != 0){
            mat[i][j] = val;
            if(i-1>=0 && mat[i-1][j]>val+1){
                helper(i-1, j,val+1, mat);
            }
            if(j-1>=0 && mat[i][j-1]>val+1){
                helper(i, j-1,val+1, mat);
            }
            if(i<mat.length-1 && mat[i+1][j]>val+1){
                helper(i+1, j,val+1, mat);
            }
            if(j<mat[0].length-1 && mat[i][j+1]>val+1){
                helper(i, j+1,val+1, mat);
            }
        }
    }
    public boolean areZero(int[][] mat, int i, int j){
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        for(int k = 0;k<dx.length;k++){
            int x = dx[k] +i;
            int y = dy[k]+j;
            if(x<0 || y<0 || x>=mat.length || y>= mat[0].length) continue;
            if(mat[x][y] == 0){
                return true;
            }
        }
        return false;
    }
}
