class Solution {
 
      private int m, n, oldColor, newColor;
      private static int[][] directions = {                                        // directions matrix
          {-1, 0},
          {0, 1},
          {1, 0},
          {0, -1}
      };
  
      public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
// ******************** BFS Approach ******************** 
  
        if(image[sr][sc] == color)                                               // if same color then return as it is
            return image;
        
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];                                            // setting old color
        int newColor = color;                                                    // setting new color
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(sr, sc));

        while(!q.isEmpty()) {
            Pair<Integer, Integer> pair = q.poll();
            for(int[] dir : directions) {                                        // go for neighbours
                sr = pair.getKey();                                              // get row index from queue
                sc = pair.getValue();                                            // get column index from queue
                
                image[sr][sc] = newColor;                                        // set that grid value to newcolor
                
                int nr = sr + dir[0];
                int nc = sc + dir[1];
                if(nr<0 || nc<0 || nr==m || nc==n || image[nr][nc]!=oldColor)    // check bounds
                    continue;
                q.add(new Pair(nr, nc));                                         // adding indexes in queue
            }
        }
        
        return image;
  
// // ******************** DFS Approach ******************** 
        
//         if(image[sr][sc] == color)                                               // if same color then return as it is
//             return image;
        
//         m = image.length;
//         n = image[0].length;
//         oldColor = image[sr][sc];                                                // setting old color
//         newColor = color;                                                        // setting new color
        
//         dfs(image, sr, sc);                                                      // calling dfs
        
//         return image;

//     }
//     private void dfs(int[][] image, int sr, int sc) {
        
//         // base cae
//         if(sr<0 || sc<0 || sr==m || sc==n || image[sr][sc]!=oldColor)            // out of bounce OR not old color
//             return;
        
//         // logic
//         for(int[] dir : directions) {
//             image[sr][sc] = newColor;                                            // setting current grid value to new color
//             int nr = sr + dir[0];
//             int nc = sc + dir[1];
//             dfs(image, nr, nc);                                                  // calling dfs for neighbours
//         }

//     }
}
