// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    q.add(new int[]{i,j});
                }else if(matrix[i][j]==1){
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] pop = q.poll();
            for(int[] dir:dirs){
                int r=dir[0] + pop[0];
                int c=dir[1] + pop[1];
                if(r>=0 && r<matrix.length && c>=0 && c<matrix[0].length && matrix[pop[0]][pop[1]]+1<matrix[r][c]){
                    matrix[r][c]=matrix[pop[0]][pop[1]]+1;
                    q.add(new int[]{r,c});
                }
            }
        }
        return matrix;
    }
}