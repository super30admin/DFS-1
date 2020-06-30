
//BFS
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
     if(matrix == null || matrix.length == 0 ) return matrix;
     
     Queue<int[]> q = new LinkedList();  
     for(int i = 0 ; i < matrix.length ; i++){
         for( int j = 0 ; j < matrix[0].length ; j++) {
             if(matrix[i][j] == 0){
                 q.add(new int[]{i,j});
             }
             else{
                 matrix[i][j] = -1;
             }
         }
     }
       
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        //int dist = 1;
        while(!q.isEmpty()){
            int size = q.size(); //to maintain the parent or level
            for(int i = 0 ; i <size;i++){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = dir[0]+ curr[0];
                int c = dir[1] + curr[1];
            if(r>=0  && c>= 0 && r<matrix.length && c < matrix[0].length && matrix[r][c] == -1 ){
                q.add(new int[]{r,c}); //add to queue
              //  matrix[r][c] = dist; //reset with dist
                matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
            }
        }
        }
           // dist++;
        }
       
      return matrix;
       
    }
}

/*
TimeComplexity : O(mxn)
SpaceCompelxity O(mxn)
*/