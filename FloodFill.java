package dfs1;

/*
Idea :  1. We check recursively if the 4-directional neighbors of a pixel are of given value.
 		2. Replace them with the new color value and keep on repeating these two steps for 
 		   subsequent neighbors of previous 4-directional neighbors.

Time Complexity : O(r*c) because in worst case, we might process whole matrix.
Space Complexity : O(r*c).

Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

public class FloodFill {

	  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        if (image[sr][sc] == newColor) return image;
	        fill(image, sr, sc, image[sr][sc], newColor);
	        return image;
	    }
	    
	    private static void fill(int[][] image, int r, int c, int color, int newColor) {
	        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != color) return;
	        image[r][c] = newColor;
	        fill(image, r + 1, c, color, newColor);
	        fill(image, r - 1, c, color, newColor);
	        fill(image, r, c + 1, color, newColor);
	        fill(image, r, c - 1, color, newColor);
	    }

	
	
	// BFS approach: we put the starting row and column in the queue and process it for finding further neighbors 
	// with same color value, replace them with new colors and place those neighbors in the queue.
	// We keep on processing the pixels in the queue until it is empty and also skip the pixels which are already visited..
	
	    // TC: O(m*n) : size of matrix
	    // SC: O(2*m*n) : one for visited matrix and one for queue.
	/*
	 import java.util.LinkedList;
	 import java.util.Queue;
	  
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
        int[] directions = new int[]{0, 1, 0, -1, 0};
        int m = image.length;
        int n = image[0].length;
        int originalValue = image[sr][sc];
        image[sr][sc] = newColor;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]] = true;
            for (int i = 0; i < directions.length - 1; i++) {
                int nextR = curr[0] + directions[i];
                int nextC = curr[1] + directions[i + 1];
                if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n || image[nextR][nextC] != originalValue || visited[nextR][nextC]) {
                    continue;
                }
                image[nextR][nextC] = newColor;
                queue.offer(new int[]{nextR, nextC});
            }
        }
        return image;
    }  
    */
	    /* time limit exceeding for below test case if we don't keep visited matrix
	     [[0,0,0],[0,1,1]]
			1
			1
			1 
	     */
	
	// Driver code 
	public static void main(String[] args)  
	{ 
	    int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1}, 
	                    {1, 1, 1, 1, 1, 1, 0, 0}, 
	                    {1, 0, 0, 1, 1, 0, 1, 1}, 
	                    {1, 2, 2, 2, 2, 0, 1, 0}, 
	                    {1, 1, 1, 2, 2, 0, 1, 0}, 
	                    {1, 1, 1, 2, 2, 2, 2, 0}, 
	                    {1, 1, 1, 1, 1, 2, 1, 1}, 
	                    {1, 1, 1, 1, 1, 2, 2, 1}, 
	                    }; 
	    int x = 4, y = 4, newC = 3; 
	    floodFill(screen, x, y, newC); 
	  
	    System.out.println("Updated screen after call to floodFill: "); 
	    for (int i = 0; i < screen.length; i++) 
	    { 
	        for (int j = 0; j < screen[0].length; j++) 
	        System.out.print(screen[i][j] + " "); 
	        System.out.println(); 
	    } 
	    }
	
}
