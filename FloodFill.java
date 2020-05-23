package s30Coding;
import java.util.*;

//Time Complexity :- O(m*n)
//Space Complextiy :- O(m*n)
//LeetCode yes;
//DFS solution

public class FloodFill {
	int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	int color;
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
		 color = image[sr][sc];
		 if(image == null || image.length == 0 || color == newColor) {
			return image;
		 }
		dfs(image,sr,sc,newColor);
		return image;
		
	}
	private void dfs(int[][] image, int sr, int sc, int newColor ) {
		
       
		if(sr < 0 || sr>= image.length || sc <0 || sc >= image[0].length ||
				image[sr][sc] != color) return;
        image[sr][sc] = newColor;
		for(int[] dir : dirs) {
			int r = dir[0] + sr;
			int c = dir[1] + sc;
			dfs(image, r, c, newColor);
		}
    }
	
	//BFS T :- m*n S :- m*n
//public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
//	int color = image[sr][sc];
////	if(image == null || image.length == 0 || color == newColor) {
////		return image;
////	}
//	Queue <int[]> q = new LinkedList<>();
//	q.add(new int[] {sr,sc});
//	image[sr][sc] = newColor;
//	int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};;
//	while(q.isEmpty()) {
//		int[] curr = q.poll();
//		for(int[] dir : dirs) {
//			int r = curr[0] + dir[0];
//			int c = curr[1] + dir[1];
//			if(r >=0 && r <image.length && c>=0 && c< image[0].length && image[r][c] == color ) {
//				image[r][c] = newColor;
//				q.add(new int[] {r,c});
//			}
//		}
//	}
//	return image;
//}
}
