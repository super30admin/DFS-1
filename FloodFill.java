import java.util.Queue;
import java.util.LinkedList;

//Time Complexity : O(m * n) because traversing the whole matrix
//Space Complexity :O(m * n) for queue space 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

public class FloodFill {
	// we will use dfs to solve this problem
	int m;
	int n;
	int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	int oldcolor;

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		m = image.length;
		n = image[0].length;

		oldcolor = image[sr][sc];

		Queue<Integer> queue = new LinkedList<>();

		if (oldcolor == color)
			return image;

		image[sr][sc] = color;

		queue.add(sr);
		queue.add(sc);

		while (!queue.isEmpty()) {
			int r = queue.poll();
			int c = queue.poll();

			for (int[] dir : dirs) {
				int nr = r + dir[0];
				int nc = c + dir[1];

				if (nr < 0 || nr == m || nc < 0 || nc == n || image[nr][nc] != oldcolor) {
					continue;
				}
				image[nr][nc] = color;
				queue.add(nr);
				queue.add(nc);
			}
		}

		return image;

	}

	//Time Complexity : O(m * n) because traversing the whole matrix
	//Space Complexity :O(m * n) for storing stack memory space 
	//Did this code successfully run on Leetcode :Yes
	//Any problem you faced while coding this :

	   public int[][] floodFillRecursive(int[][] image, int sr, int sc, int color) { 
	        int initClr = image[sr][sc];  
	         m = image.length;
	         n = image[0].length;
	        
	        dfs(image,sr,sc,initClr,color);
	        return image;
	    }
	    
	    public void dfs(int[][] image, int i,int j,int initClr, int color){
	        
	            image[i][j] = color;    
	            
	            for(int[] dir:dirs){
	               int r = dir[0]+i; 
	               int c = dir[1]+j; 
	             
	                if(r <0 || r>= m || c <0 || c >= n || image[r][c]!=initClr ||image[r][c]==color  ){
	                    continue;
	                }
	                else{
	                   dfs(image,r,c,initClr,color);
	                }
	                
	            }
	    }
	    
}
