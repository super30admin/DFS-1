import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix == null || matrix.length ==0 ) return matrix;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i=0 ; i < n ; i++){
            for(int j =0; j< m ; j++){
               if(matrix[i][j] != 0){
                   matrix[i][j] = BFS(matrix,i,j);
               } 
            }
        }  
        return matrix;
    }
    
    private int BFS(int[][] matrix, int i , int j){
        Queue <int []> q = new LinkedList<>();
        q.add(new int[] {i,j});
        int [][] dirs = new int[][] {{0 ,1}, {1,0} , {-1,0} , {0,-1} };
          int dist =0 ;
        // iterate over the queue, poll out root and process all its children/nodes
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0; k< size ;k++){
                //polling out the root
                int [] curr = q.poll();
              
                //iterate dirs array for 4 directions
                for(int [] dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    
                    //check inbounds
                    if(r >=0 && r < matrix.length &&
                      c >= 0 && c < matrix[0].length){
                        //if zero found , return distance,
                        if(matrix[r][c] == 0) return dist +1;
                        //else add the next non zero/1 into the queue and process
                        q.add(new int[] {r,c});
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}