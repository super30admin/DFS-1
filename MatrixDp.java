//idea:For each 1, the minimum path to 0 can be in any direction. 
//So, we need to check all the 4 direction. In one iteration from top to bottom, we can check left and top directions, 
//and we need another iteration from bottom to top to check for right and bottom direction.
//Time complexity: O(r⋅c).
//Space complexity: O(r⋅c).

//BFS Apprach:did not understand fully

public class MatrixDp {

	
	 public  static int[][] updateMatrix(int[][] matrix) {
	       int rows = matrix.length;
	        int col = matrix[0].length;
	    if (rows == 0 || col == 0) {
	        return matrix;
	    }
	    int[][] dis = new int[rows][col];
	    int range = rows * col;
	    //First pass: check for left and top
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < col; j++) {
	            if (matrix[i][j] == 0) {
	                dis[i][j] = 0;
	            } else {
	               
	                int upCell = (i > 0) ? dis[i - 1][j] : range; //check distance of neighbour-earlier row and same col
	                int leftCell = (j > 0) ? dis[i][j - 1] : range;//check distance of neighbour-earlier col and same row
	                dis[i][j] = Math.min(upCell, leftCell) + 1; // compare both the neighbour distance and select min and add 1.
	            }
	        }
	    }
	    //Second pass: check for bottom and right
	    for (int i = rows - 1; i >= 0; i--) {
	        for (int j = col - 1; j >= 0; j--) {
	            if (matrix[i][j] == 0) {
	                dis[i][j] = 0;
	            } else {
	                int downCell = (i < rows - 1) ? dis[i + 1][j] : range; //check distance of neighbour - next row and same col.
	                int rightCell = (j < col - 1) ? dis[i][j + 1] : range;//check distance of neighbour - next col and same row.
	                dis[i][j] = Math.min(Math.min(downCell, rightCell) + 1, dis[i][j]);//compare and select min and add 1.
	            }
	        }
	    }
	    
	    return dis;
	    }
	 
	 //BFS 
	/* public int[][] updateMatrix(int[][] matrix) {
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        Queue<int[]> queue = new LinkedList<>();
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (matrix[i][j] == 0) {
	                    queue.offer(new int[] {i, j});
	                }
	                else {
	                    matrix[i][j] = Integer.MAX_VALUE;
	                }
	            }
	        }
	        
	        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	        
	        while (!queue.isEmpty()) {
	            int[] cell = queue.poll();
	            for (int[] d : dirs) {
	                int r = cell[0] + d[0];
	                int c = cell[1] + d[1];
	                if (r < 0 || r >= m || c < 0 || c >= n || 
	                    matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
	                queue.add(new int[] {r, c});
	                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
	            }
	        }
	        
	        return matrix;
	    }*/
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][]={{0,0,0},{0,1,0},{0,0,0}}; 
		int[][] result = updateMatrix(matrix);
		 for (int index = 0; index < result.length; index++) {
			 System.out.println("updated matrix  is ="+result[index]);
			    	
				}
	}

}
