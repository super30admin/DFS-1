// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Iterate over the whole matrix and change all 1's to Integer Max value and add all 0's indexes to queue.
// Create a direction matrix for one unit distance in 4 sides. check the directions is valid and if the condition (current cell + 1 < next cell) satisfies then
// continue updating the next cell with the current+1 value and add that value to the queue for futher checks from that point.
// likewise it updates all the distances from 0's to 1's.
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