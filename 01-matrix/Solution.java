class Solution {
    
    public int helper(int[][] matrix, int[][] dp, int i, int j){
         //System.out.println(i  + " " + j);
        if(i<0 || i>matrix.length-1 || j<0 || j>matrix[0].length-1)
            return 9999;
        if(matrix[i][j] == 0) return 0;
        if(i > 0 && matrix[i-1][j] == 0) return 1;
        if(i < matrix.length-1 && matrix[i+1][j] == 0) return 1;
        if(j > 0 && matrix[i][j-1] == 0) return 1;
        if(j < matrix[0].length-1 && matrix[i][j+1] == 0) return 1;
        
       int top = 9999; int left = 9999;
        
        if(i > 0 && dp[i-1][j] != 0) {
            top = dp[i-1][j];
        }
        if(j > 0 && dp[i][j-1] != 0){
            left = dp[i][j-1];
        }
        //int top = helper(matrix, dp, i-1, j);
         int bottom = helper(matrix, dp, i+1, j);        
        //int left = helper(matrix, dp, i, j-1);
        int right = helper(matrix, dp, i, j+1); 
        
        return Math.min(Math.min(top, bottom), Math.min(left, right))+1;
    }
    public int[][] updateMatrix(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                //if(matrix[i][j] != 0){
                    dp[i][j] = helper(matrix, dp,i,j);
                //}
            }
        }
        
        return dp;
    }

    public static void main(String[] args) {
        System.out.println("01 matrix");
        int[][] matrix = {
                {1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1}, 
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1},
        };
        Solution obj = new Solution();
        int[][] dp = obj.updateMatrix(matrix);

        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}