//Time Complexity:O(M+N) where M and N are rows and columns
//Space Complexity:O(N)
//In this problem, I'll fill the resultant array in a dfs fashion.I'll check if the border conditions are satisfied. If not, I'll be returning 9999, since the max elements in the matrix cannot exceed 9999. If the current element is 0 I'll simply return 0. If my top, bottom , right por left element is 0, I'll simply return 1. Else, I'll traverse through the next top , right, bottom and left elements in a recursive manner until I meet the boundary conditions. I'll then return the min of top, bottom , left and right.
//This code was executed successfully and got accepted in leetcode. 
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] res=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                res[i][j]=dfs(matrix,res,i,j);
            }
        }
        return res;
    }
    private int dfs(int[][] matrix,int[][] res,int i,int j){
        int row=matrix.length;
        int col=matrix[0].length;
        if(i<0||i>=row||j<0||j>=col){
            return 9999;
        }
        if(matrix[i][j]==0){
            return 0;
        }
        if(i>0&&matrix[i-1][j]==0){
            return 1;
        }
        if(i<row-1&&matrix[i+1][j]==0){
            return 1;
        }
        if(j>0&&matrix[i][j-1]==0){
            return 1;
        }
        if(j<col-1&&matrix[i][j+1]==0){
            return 1;
        }
        int top,left,right,bottom;
        top=left=9999;
        if(i>0&&res[i-1][j]!=0){
            top=res[i-1][j];
        }
        if(j>0&&res[i][j-1]!=0){
            left=res[i][j-1];
        }
        bottom=dfs(matrix,res,i+1,j);
        right=dfs(matrix,res,i,j+1);
        return Math.min(Math.min(left,right),Math.min(top,bottom))+1;
    }
}