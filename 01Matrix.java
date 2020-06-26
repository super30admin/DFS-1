class Solution {
// Time Complexity : O(m*n)  when are all are 1's
// Space Complexity : O(m*n) when are all are 1's
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Use bfs method through queue and traverse till all indices are covered.
 */
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0) return matrix;
        Queue<int[]> q = new LinkedList<>();
        for(int i =0;i<matrix.length; i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    matrix[i][j] = -1;
                }
                else{
                    q.add(new int[] {i,j});
                }
            }
        }
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int adjacencyCount = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r>=0 && r<matrix.length && c>=0 && c<matrix[0].length && matrix[r][c]==-1 ){
                    matrix[r][c] = adjacencyCount;
                    q.add(new int[] {r,c});
                }
            }}
            adjacencyCount++;            
        }
        return matrix;
    }
}