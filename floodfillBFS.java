package DFS1;

/*
BFS
Time Complexity: O(m * n)
Space Complexity: O(m * n) */

import java.util.LinkedList;
import java.util.Queue;

public class floodfillBFS {

public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
	        //Null Case
	        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;
	        int m = image.length;
	        int n = image[0].length;
	        int color = image[sr][sc];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(new int[] {sr, sc});
	        image[sr][sc] = newColor;
	        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	        while(!queue.isEmpty()) {
	            int[] curr = queue.poll();
	            for(int[] dir: dirs) {
	                int nr = dir[0] + curr[0];
	                int nc = dir[1] + curr[1];
	                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color) {
	                    queue.add(new int[] {nr, nc});
	                    image[nr][nc] = newColor;
	                }
	            }
	        }
	        return image;
	    }
}
