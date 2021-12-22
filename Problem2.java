//time O(mn
//space o(1)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int i=0; i< mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                int minValue = -1;
                if(mat[i][j] == 1) {
                    for(int[] dir : dirs) {
                        int nextX = i+dir[0];
                        int nextY = i+dir[i];
                        if(nextX >=0 && nextX < mat.length && nextY >=0 && nextY < mat[0].length) {
                            minValue = Math.min(minValue, mat[nextX][nextY]);
                        }
                    }
                    mat[i][j] = minValue+1;
                }
            }
        }
        return mat;
    }
    
}
