
import java.util.*;

//BFS
//Time com - o(mn)
//Space com - o(mn)
//Lettcode - Yes
public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		//if old color is same as the new return 
		if (image == null || image.length == 0 || image[sr][sc] == newColor)
			return image;

		int m = image.length, n = image[0].length, oldColor = image[sr][sc];
		image[sr][sc] = newColor;
		//add r and c to queue after changing the color
		Queue<Integer> q = new LinkedList<>();
		q.add(sr);
		q.add(sc);
		
		//if queue is not empty keep iterating neighbors
		while (!q.isEmpty()) {
			int cr = q.poll();
			int cc = q.poll();
			//neighbours
			int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
			for (int[] dir : dirs) {
				int r = cr + dir[0];
				int c = cc + dir[1];
				//boundry check and color hsold be old not zero
				if (r >= 0 && c >= 0 && r < m && c < n && image[r][c] == oldColor) {
					image[r][c] = newColor;
					q.add(r);
					q.add(c);
				}
			}
		}
		return image;
	}
	
	//DFS
	//Time com - o(mn)
	//Space com - o(mn) aux
	//Lettcode - Yes
//	int m,n,oldColor;
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        
//        if(image == null || image.length == 0 || image [sr][sc] == newColor) return image;
//        
//        m = image.length; n = image[0].length;
//        oldColor = image[sr][sc];
//        dfs(image,sr,sc,newColor);
//
//        return image;
//    }
//    private void dfs(int[][] image, int sr, int sc, int newColor) {
//        //base
//        if(sr<0 || sc<0 || sr>=m || sc>=n || image[sr][sc] != oldColor)
//            return;
//        image[sr][sc] = newColor;
//        //logic
//        int [][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
//        for(int [] dir: dirs){
//            int r = sr + dir[0];
//            int c = sc + dir[1];
//            dfs(image,r,c,newColor);
//        }
//    }

}
