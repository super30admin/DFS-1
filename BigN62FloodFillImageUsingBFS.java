//Time complexity is O(m*n) i.e row*column.
//Space complexity is O(m*n) i.e row*column elements in queue.
//This solution is submitted on leetcode

import java.util.LinkedList;
import java.util.Queue;

public class BigN62FloodFillImageUsingBFS {
	class Solution {
	    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        //edge case
	        if(image.length == 0 || image == null || image[sr][sc]== newColor)
	            return image;
	        int row = image.length;
	        int column = image[0].length;
	        int oldColor = image[sr][sc];
	        image[sr][sc] = newColor;
	        Queue<int []> q = new LinkedList<>();
	        q.add(new int [] {sr,sc});
	        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	        while(!q.isEmpty()){
	            int [] checker = q.poll();
	            for(int [] dir:dirs){
	                int r = checker[0]+ dir[0];
	                int c = checker[1]+dir[1];
	                if(r>=0 && r<row && c>=0 && c<column &&image[r][c] == oldColor){
	                    q.add(new int[]{r,c});
	                    image[r][c]=newColor;
	                }
	            }
	        }
	        return image;
	    }
	}
}