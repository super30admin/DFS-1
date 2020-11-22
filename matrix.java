class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int k =helper(i,j,0);
                matrix[i][j]= k;
            }
        }
    }
    private helper(int r, int c,int dist ){
        if(r> image.length-1 || r < 0 || c > image[0].length-1 || s < 0) return;
        if(matrix[r][c]==0){
            return dist;
        }
        
        int [][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        int min=0;
        for(int[][] dir: dirs){
            int i= r+dir[0];
            int j= c+dir[1];
           int dist = helper(i,j,dist+1);
            if(dist)
        }
        
    }
}
