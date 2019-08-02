//DFS solution: Say color is the color of the starting pixel. Let's floodfill the starting pixel: 
//we change the color of that pixel to the new color, then check the 4 neighboring pixels to make sure they are valid pixels of the same color, 
//and of the valid ones, we floodfill those, and so on.
//We can use a function dfs to perform a floodfill on a target pixel.
//Time Complexity: O(N), where N is the number of pixels in the image. We might process every pixel.
//Space Complexity: O(N), the size of the implicit call stack when calling dfs


//BFS Solution: store element which needs to do recolour ,into queue and check all it's neighbourhood one by  one and recolour it with new colour and store neighbours into queue.
//process goes on till queue is empty
////Time Complexity: O(N)
//Space Complexity: O(N)

//error:array index out of bound while printing output
public class FoodFill {
	
	//DFS Solution using recursion
	    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	         int colour = image[sr][sc];
	         if(colour!=newColor) dfs(image,sr, sc,colour,newColor);
	         return image;
	    }
	    
	    public static void dfs(int[][] image, int r, int c, int color, int newColor){
	        if(image[r][c] == color){
	            image[r][c] = newColor;
	            if(r>=1) dfs(image, r-1, c,color,newColor);
	            if(c>=1) dfs(image, r, c-1,color,newColor);
	            if(r+1<image.length) dfs(image, r+1, c,color,newColor);
	            if(c+1<image[0].length) dfs(image, r, c+1,color,newColor);
            
	        }
	        
	        //BFS traversal using queue.
/*	        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	            int row = image.length;
	             int col =image[0].length;
	             int color = image[sr][sc];
	             image[sr][sc] = newColor;
	             
	             Queue<int[]> q = new LinkedList<>();
	             boolean[][] visited = new boolean[row][col];
	             q.offer(new int[]{sr,sc});
	             int[][] dirs ={{1,0},{-1,0},{0,1},{0,-1}};
	             while(!q.isEmpty()){
	                 int[] curr =q.poll();
	                 visited[curr[0]][ curr[1]] = true;
	                 for(int[]dir :dirs){
	                      int x = curr[0]+ dir[0];
	                      int y =  curr[1]+dir[1];
	                      if(x>=row || y>=col || x<0 ||y<0 || image[x][y]!= color || visited[x][y]) continue;
	                      image[x][y] = newColor;
	                      q.offer(new int[]{x,y});
	                 }
	             }
	             return image;
	         }*/
	        
	    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int image[][]={{1,1,1},{1,1,0},{1,0,1}}; 
		int rows= image.length;
		int col = image[0].length;
		int sr =1;
		int sc=1;
		int newColour =2;
		int result[][] = floodFill(image,sr,sc,newColour);
		 for (int i = 0; i < rows; i++) {
			 for (int j = 0; j < col; i++) {
			 System.out.println("Fod Fill is ="+result[i][j]);
			    	
				}
	  }
	}
}
