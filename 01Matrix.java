// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using BFS Approach

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> que = new LinkedList();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0)
                    que.add(new int[]{i,j});
                else
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!que.isEmpty()){
            int[] n = que.poll();
            for(int[] d:dirs){
                int r = n[0]+d[0];
                int c = n[1]+d[1];
                if(r >=0 && r< matrix.length && c>=0 && c < matrix[0].length && matrix[r][c] > matrix[n[0]][n[1]]+1){
                    matrix[r][c] = matrix[n[0]][n[1]]+1;
                    que.add(new int[]{r,c});
                }
            }
        }
        return matrix;
    }
}
