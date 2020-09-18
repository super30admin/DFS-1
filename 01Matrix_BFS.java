// Time Complexity : O(m*n) m = number of rows, n = number of columns
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0)    return matrix;
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new Pair<>(i,j));
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                Pair<Integer,Integer> p = queue.poll();
                int r = p.getKey();
                int c = p.getValue();
                
                for(int dir[]: dirs){
                    int x = dir[0] + r;
                    int y = dir[1] + c;
                    
                    if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                      && matrix[x][y] == -1){
                        matrix[x][y] += matrix[r][c] + 2;
                        queue.offer(new Pair<>(x,y));
                    }
                }
            }
            
        }
        return matrix;
    }
}
