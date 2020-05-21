// Time Complexity : O(rows*columns)
// Space Complexity : O(rows*columns)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        int rowLen = matrix.length,colLen = matrix[0].length;
        int[][] result = new int[rowLen][colLen];
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(matrix[i][j]==0)
                    q.add(i*colLen+j);
            }
        }
        
        while(!q.isEmpty()){
            int val = q.poll();
            int row = val/colLen;
            int col = val%colLen;
            
            helper(row,col,matrix,q,result);
            
            
        }
        return result;
    }
        
    public void helper(int r, int c, int[][] matrix, Queue<Integer> q, int[][] result){
        int ax[] = {-0,1,0,-1};
        int ay[] = {1,0,-1,0};
        
        for(int i=0;i<4;i++){
            int x=r+ax[i];
            int y=c+ay[i];
            
            if(x>=0 && y>=0 && x<matrix.length && y<matrix[0].length && matrix[x][y]!=0){
                result[x][y]=result[r][c]+1;
                matrix[x][y]=0;
                q.add(x*matrix[0].length+y);
            }
        }
    }
}
