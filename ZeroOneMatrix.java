public class ZeroOneMatrix {
  /**
   * Approach 1 : BFS
   * 
   * Time Complexity: O( m * n )
   * 
   * Space Complexity: O ( m * n)
   */
  public int[][] updateMatrix(int[][] mat) {
        
    int[][] dirs = new int[][]{{-1,0}, {1, 0}, {0, 1}, {0, -1}};
    int m = mat.length;
    int n = mat[0].length;
    Queue<int[]> queue = new LinkedList<>();
    
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(mat[i][j] == 1){
                mat[i][j] = -1;
            }
            
            if(mat[i][j] == 0){
                queue.add(new int[]{i, j});
            }
        }
    }
    
    int dist = 1;
    while(!queue.isEmpty()){
        int size = queue.size();
        
        for(int i = 0; i < size; i++){
            int[] curr = queue.remove();
            
            for(int[] dir : dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1){
                    mat[nr][nc] = dist;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        
        dist++;
    }
    
    return mat;
}
}
