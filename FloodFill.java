package com.exmaple.problems;

import java.util.LinkedList;
import java.util.Queue;
//Time Complexity : O(mn) for DFS,BFS
//Space Complexity : O(1) for DFS,O(N) for BFS
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
* 
*/
public class FloodFill {
	int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor)
			return image;
		int color = image[sr][sc];
		dfs(image, sr, sc, newColor, color);
		return bfs(image,sr,sc,newColor);
	}

	private void dfs(int[][] image, int sr, int sc, int newColor, int color) {
		// base case
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
			return;
		image[sr][sc] = newColor;
		// Initiate a directions array
		for (int[] dir : dirs) {
			int i = dir[0] + sr;
			int j = dir[1] + sc;
			// recurse on all neigbors.
			dfs(image, i, j, newColor, color);
		}
	}

	public int[][] bfs(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor)
			return image;
		Queue<int[]> q = new LinkedList<>();
		int color = image[sr][sc];
		boolean[][] visited = new boolean[image.length][image[0].length];
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			image[curr[0]][curr[1]] = newColor;
			for (int[] dir : dirs) {
				int i = dir[0] + curr[0];
				int j = dir[1] + curr[1];
				if (i >= 0 && i < image.length && j >= 0 && j < image[0].length && image[i][j] == color
						&& !visited[i][j]) {
					q.add(new int[] { i, j });
					// Mark Visited
					visited[i][j] = true;
				}
			}
		}
		return image;
	}
}
