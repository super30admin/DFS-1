// Time Complexity :O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int[][] directions = new int[][] {{-1,0}, {1,0}, {0,-1} , {0, 1}};
        Queue<int []> queue = new LinkedList<>();
        int dist = 1;
        for(int i = 0 ; i<mat.length ; i++){
            
            for(int j = 0; j< mat[0].length ; j++){
                
                if(mat[i][j] == 1){
                    mat[i][j] = -1;
                }
                if(mat[i][j] == 0){
                    queue.add(new int[] {i,j});
                }
                
            }
        }
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0 ; i < size ; i++){
                
                int[] curr = queue.poll();
                
                for(int[] dir : directions){
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];
                    if(row >= 0 && row < mat.length && col >= 0 && col < mat[0].length && mat[row][col] == -1){
                          queue.add(new int[] {row,col});
                       mat[row][col] = dist;
                    }
                }  
            }
            
            dist++;
        }
        
        return mat;
        
    }
}