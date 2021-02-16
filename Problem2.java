// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :Yes
//Stack overflow while checking every neighbour

// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]!=0)
                    matrix[i][j]=DFS(matrix,i,j);
            }
        }
        return matrix;
        
    }
    public int DFS(int[][] matrix,int i, int j )
    {
        int dist=0;
        int row=matrix.length;
        int col= matrix[0].length;
        if(matrix[i][j]!=1)
            return matrix[i][j];
        if(i-1>=0){ dist=DFS(matrix,i-1,j)+1;}
        if(j-1>=0){ dist=DFS(matrix,i,j-1)+1;}
        if(i+1<row){ dist=DFS(matrix,i+1,j)+1;}
        if(j+1<col){ dist=DFS(matrix,i,j+1)+1;}
        return dist;
        
    }
}