// Time Complexity :O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach



class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        
        if(matrix == null || matrix.length == 0 )
            return matrix;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
                else{
                    matrix[i][j] = -1;

                }
            }
        }
        
        int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0}};
        int distance = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i <  size; i++){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                     int r = dir[0] + curr[0];
                     int c = dir[1] + curr[1];
                     if(r >= 0 && r < m && c >=0 && c < n){
                         if(matrix[r][c] == -1)
                         {
                             queue.add(new int[]{r,c});
                             matrix[r][c] = distance;
                         }
                         
                     }
                }
            }
            distance++;
        }        
         return matrix;
    }
}