class FloodFill {
    // Approach 1 - BFS
   // Time complexity - O(n*m)
   // Space complexity - O(n*m) 
   
   // This function uses queue to maintains the neighbour of the cell and changes color of neighbours.
   public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
       
       // queue for storing neighbours of the cell
       Queue<int[]> queue = new LinkedList<>();
       queue.offer(new int[]{sr,sc});
       int color = image[sr][sc];
       image[sr][sc] = newColor;
       
       // valid directions of traversal
       int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
       
       // loop till queue is empty
       while(!queue.isEmpty()){
           // pop each cell indexes of the cell, change its color, find its valid neighbour and push to the queue.
           int[] temp = queue.poll();
           for(int[] dir : directions){
               int r = temp[0] + dir[0];
               int c = temp[1] + dir[1];
              
               // discard invalid neighbours and check boundary condition of the cell
               if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] == newColor ||image[r][c] != color )
                   continue;
           
                   image[r][c] = newColor;
                   queue.offer(new int[]{r,c});
           
           }
       }
       return image;
   }
   
   // Approach 2 - DFS
   // Time complexity - O(n*m)
   // Space complexity - O(n*m) for recursion stack
   
   // Driver function, check the color of the given cell, if different then given color then call helper function for recursion.
   public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
       int color = image[sr][sc];
       if(color != newColor)
           dfs(image,sr,sc,color,newColor);
       return image;
   }
   
   // helper function, recurse through all neighhbours of the the  given cell and change its color to the desired color.
   public void dfs(int[][] image, int sr, int sc, int color, int newColor){
       if(image[sr][sc] == color)
       {
       image[sr][sc] = newColor;
           
       // find neighbours by traversing to valid directions.
       if(sr+1 < image.length)
           dfs(image,sr+1,sc,color,newColor);
       if(sr-1 >=0 )
           dfs(image,sr-1,sc,color,newColor);
       if(sc+1 < image[0].length)
           dfs(image,sr,sc+1,color,newColor);
       if(sc-1 >=0 )
           dfs(image,sr,sc-1,color,newColor);
       }
   }
}