 class Solution {
	    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        
	        //BFS
	        //base case
	        if(image==null || image.length==0 || newColor == image[sr][sc]){
	            return image;
	        }
	        //Logic
	        int m = image.length;
	        int n = image[0].length;
	        int color = image[sr][sc];//initital color
	        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	        image[sr][sc] = newColor;
	        
	        Queue<int[]> q = new LinkedList<>();
	        q.add(new int[] {sr,sc});
	        while(!q.isEmpty()){
	            int[]  curr = q.poll();
	            for(int[] dir: dirs){
	                int r = curr[0]+dir[0];
	                int c = curr[1]+dir[1];
	                if(c>=0 && c<n && r>=0 && r<m && image[r][c]==color){
	                    q.add(new int[] {r,c});
	                    image[r][c] = newColor;
	                }
	            }
	            
	        }
	        return image;
	    }
	}