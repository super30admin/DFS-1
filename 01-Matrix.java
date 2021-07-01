/*TC- O(M*N) SC - O(M*N)
 *
 */
 class Solution {
    public int[][] updateMatrix(int[][] mat) {
       
        // mark every 1 as -1 and with every neighbour as -1, replace with its distance 
        
        // indepenedant nodes - all zeroes
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < mat.length; i++){
            for(int j = 0 ; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                }else {
                    mat[i][j] = -1;
                }
               
            }
        }
        
int[][]dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        
        int m = mat.length;
        int n = mat[0].length;
        int dist = 0;
        while(!queue.isEmpty()){
            dist +=1;
            int size = queue.size();
             for (int i = 0 ; i < size; i++){
                  
                  int[] curr = queue.poll();
                   for (int[] dir:dirs){
                        int nr = dir[0] + curr[0];
                        int nc = dir[1] + curr[1];
                       if(nr < m && nc < n && nr >= 0 && nc >= 0 && mat[nr][nc] == -1){
                            queue.add(new int[]{nr, nc});
			    // update the distance 
                           mat[nr][nc] = dist;
                          
                       }
                    }
     
             }
           
              
        }
      
        return mat;
        
    }
}

