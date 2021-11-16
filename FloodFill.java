// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class FloodFill {
	  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        if(newColor==image[sr][sc]) return image;
	        dfs(image,sr,sc,newColor,image[sr][sc]);  
	        return image;
	    }
	    
	    public void dfs(int[][] image, int i, int j, int newColor, int currColor){
	        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=currColor){
	            return;
	        }
	        
	        image[i][j]=newColor;
	        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
	        for(int[] dir:dirs){
	            int row=i+dir[0];
	            int col=j+dir[1];
	            dfs(image, row, col,newColor,currColor);
	        }
	    }
}
