/*************************************Using BFS***********************************************/
// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/* Using BFS, if new color is already equal to the given cell, we just return the image 
 * using queue, we first add the given row and col (indices) to the queue and change its color as newcolor
 * by traversing, we change the colors of the neighboring cells and add them to the queue
 * this will be done iteratively until all the neighboring cells have changed their color*/

import java.util.*;

class Flood_FillBFS {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(image[sr][sc] == newColor)   //if newcolor is already equal to the {sr,sc}
			return image;   

		int color = image[sr][sc];
		int dirs[][] = {{0,1}, {0,-1}, {-1,0}, {1,0}};

		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {sr, sc});

		image[sr][sc] = newColor;   // making the color at that point as new color

		while(!q.isEmpty()){
			int curr[] = q.poll();  //remove the coordinates of point from queue
			for(int[] dir: dirs){   //traversing in all four directions
				int r = curr[0] + dir[0];
				int c = curr[1] + dir[1];

				if(r >= 0 && c >= 0 && r < image.length && c < image[0].length && image[r][c] == color){    // check bounds and if the neighbour has same color as oldcolr at starting point
					image[r][c] = newColor; //make it to newcolor
					q.add(new int[] {r, c}); // add it to the queue
				}  
			}
		}
		return image;
	}
}


/*************************************Using DFS***********************************************/
//Time Complexity : O(m * n)
//Space Complexity : O(m * n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


/* Using DFS, if new color is already equal to the given cell, we just return the image 
 * traverse to the neighbors of the given cell first, then call dfs until all the neighbors of that particular cell have changed their color
 * after all recursive calls we have filled the image with the given color */

class Flood_FillDFS {
	int color;
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(image[sr][sc] == newColor)   //if newcolor is already equal to the {sr,sc}
			return image;   

		color = image[sr][sc]; 

		dfs(image, sr, sc, newColor);
		return image;
	}

	private void dfs(int[][] image, int sr, int sc, int newColor){
		//base
		if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
			return;

		//logic
		int dirs[][] = {{0,1}, {0,-1}, {-1,0}, {1,0}};

		image[sr][sc] = newColor;

		for(int[] dir: dirs){   //traversing in all four directions
			int r = sr + dir[0];
			int c = sc + dir[1];
			dfs(image, r, c, newColor);
		}
	}
}