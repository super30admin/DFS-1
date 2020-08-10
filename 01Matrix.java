// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        
        Queue<int []> q = new LinkedList<>();
        
        for(int i = 0; i< matrix.length; i++)
        {
            for(int j = 0; j <matrix[0].length; j++)
            {
                 if(matrix[i][j] == 0){
                    q.add(new int [] {i, j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty())
        {
            int [] cur = q.poll();
            for(int[] dir : dirs)
            {
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                   if(r>=0 && r<matrix.length && c>=0 && c<matrix[0].length && matrix[r][c] == -1){
                    matrix[r][c] = matrix[cur[0]][cur[1]]+1;
                    q.add(new int[]{r,c});
                }
            }
        }
        return matrix;
        
    }
}