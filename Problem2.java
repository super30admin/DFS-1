// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :Yes
//Stack overflow while checking every neighbour

// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1)
                    matrix[i][j]=Integer.MAX_VALUE;
                else
                    q.add(new int[]{i,j});          
            }
        }
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] axis= q.poll();
            for(int[] d: directions ){
               
                int x=axis[0]+d[0];
                int y=axis[1]+d[1];
                
                if(x>=0 && y>=0 && x<matrix.length && y<matrix[0].length &&  matrix[x][y]>matrix[axis[0]][axis[1]]+1){
                    matrix[x][y]=matrix[axis[0]][axis[1]]+1;
                    q.add(new int[]{x,y});
                }

            }
        }
        
        return matrix;
    }
}