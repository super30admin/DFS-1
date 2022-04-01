class FloodFill {
  /**
   * Approach 1: BFS
   * 
   * Time Complexity: O(m * n)
   * 
   * Space Complexity: O(m * n)
   * 
   * Were you able to solve this on Leetcode?  Yes
   * 
   */

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    Queue<int[]> queue = new LinkedList<>();
    int color = image[sr][sc];
    if(color == newColor) { return image; }
    int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    int m = image.length;
    int n = image[0].length;
    image[sr][sc] = newColor;
    queue.add(new int[]{sr, sc});
    
    while(!queue.isEmpty()){
        int size = queue.size();
        
        for(int i = 0; i < size; i++){
            int[] curr = queue.remove();
            for(int[] dir : dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                
                if(nr >= 0 && nc >= 0 &&  nr < m && nc < n && image[nr][nc] == color){
                    image[nr][nc] = newColor;
                    queue.add(new int[]{ nr, nc });
                }
            }
        }
    }
    
    return image;
  }

  /**
   * Approach 2: DFS
   * 
   * Time Compelxity : O(m * n)
   * 
   * Space Complexity: O( m * n)
   * 
   * Were you able to solve this on leetcode? Yes
   * 
   */
  int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      
      if(image[sr][sc] == newColor) { return image; }
      
      dfsHelper(image, sr, sc, image[sr][sc], newColor);
      return image;
  }
    
  void dfsHelper(int[][] image, int i, int j, int color, int newColor) {
      // base cases
      if(i < 0 || j < 0 || i == image.length || j == image[0].length || image[i][j] != color
        ) { return ; }
      
      // dfs
      image[i][j] = newColor;
      
      for(int[] dir : dirs){
          int nr = i + dir[0];
          int nc = j + dir[1];
          
          dfsHelper(image, nr, nc, color, newColor);
      }
  }
}