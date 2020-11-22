// Time Complexity :O(row*col).
// Space Complexity :O(row*col).
// Did this code successfully run on Leetcode :Yes.
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach

class NearestZero {
	
	 public int[][] updateMatrix(int[][] matrix) {
	        if(null == matrix || 0 == matrix.length){return matrix;}
	        Queue<int[]> q = new LinkedList<>();
	        for(int i = 0; i < matrix.length; i++){
	            for(int j = 0; j < matrix[0].length; j++){
	                if(matrix[i][j] != 0){
	                    matrix[i][j] = Integer.MAX_VALUE;
	                }else{
	                    q.offer(new int[]{i,j});
	                }
	            }
	        }
	        int dirs[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int k = 0; k < size; k++){
	            int point[] = q.poll();
	            int newDistance = matrix[point[0]][point[1]] + 1;
	            for(int dir[]: dirs){
	                int r = point[0] + dir[0];
	                int c = point[1] + dir[1];
	                if(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length){
	                 if(matrix[r][c] != 0 && newDistance < matrix[r][c]){
	                    matrix[r][c] = newDistance;
	                     q.offer(new int[]{r,c});
	                 }   
	                }
	            }
	         }
	        }
	        return matrix;
	    }
	
    public int[][] updateMatrix1(int[][] matrix) {
        if(null == matrix || 0 == matrix.length){return matrix;}
        int dist[][] = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] != 0){
                    dist[i][j] = bfs(matrix,i,j);
                }
            }
        }
        return dist;
    }
    public int bfs(int[][] matrix, int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        int dist = 0;
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i = 0; i < size; i++){
                int arr[] = q.poll();
                for(int dir[]: dirs){
                    x = arr[0] + dir[0];
                    y = arr[1] + dir[1];
                    if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length){
                        if(matrix[x][y] == 0){
                            return dist;
                        }  
                        q.offer(new int[]{x,y});
                    }
                }
            }
        }
    return -1;
    }
}