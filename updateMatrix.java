// Time Complexity :O(MxN)
// Space Complexity :O(MxN)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        Queue<Pair<Integer,Integer>> q = new LinkedList();
        
        for(int i=0;i<matrix.length; i++){
            for(int j=0;j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    q.offer(new Pair<>(i,j));
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        
        int dirs [][] = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> p = q.poll();
                int r = p.getKey();
                int c = p.getValue();
                
                for(int [] dir : dirs){
                    int x = dir[0]+r;
                    int y = dir[1]+c;
                    
                    if(x >= 0 && x < matrix.length && y >= 0 && 
                        y < matrix[0].length && matrix[x][y] ==-1 ){
                        matrix[x][y] += matrix[r][c] +2;
                        
                        q.offer(new Pair<>(x,y));
                    }
                    
                }
            }
        }
         
        return matrix;
    }
}
