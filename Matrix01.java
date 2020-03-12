import java.util.Arrays;

/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Space complexity is O(R X C) since we are using a stack to store all the elements.
//Time complexity is O(RXC) since we are interating through all the elements
public class Matrix01 {

	/**
	 * @param args
	 */
	
	   public int[][] updateMatrix(int[][] matrix) {
	        if(matrix.length==0) return matrix;
	        
	        for(int i = 0; i<matrix.length; i++)
	            for(int j = 0; j<matrix[0].length; j++)
	                if(matrix[i][j]==1&&!hasNeiberZero(i, j,matrix)) // Iterate through all the values  and add the distances
	                    matrix[i][j] = matrix.length+matrix[0].length+1;
	        
	        for(int i = 0; i<matrix.length; i++)
	            for(int j = 0; j<matrix[0].length; j++)
	                if(matrix[i][j]==1)// If 1 value is found start the DFS from the that point
	                    dfs(matrix, i, j, 1);
	        
	        return matrix;
	    }
	    private void dfs(int[][] matrix, int x, int y, int val){
	        if(x<0||y<0||y>=matrix[0].length||x>=matrix.length||(matrix[x][y]<=val && val != 1))
	            return;

	        matrix[x][y] = val;
	        
	        dfs(matrix, x+1, y, matrix[x][y]+1);
	        dfs(matrix, x-1, y, matrix[x][y]+1);//Check the neighbours using 4 connected componenets
	        dfs(matrix, x, y+1, matrix[x][y]+1);
	        dfs(matrix, x, y-1, matrix[x][y]+1);
	        
	    }
	    private boolean hasNeiberZero(int x, int y, int[][] matrix){
	        if(x>0&&matrix[x-1][y]==0) return true;// If left neighbour is zero return true
	        if(x<matrix.length-1&&matrix[x+1][y]==0) return true;// If  right is true return zero
	        if(y>0&&matrix[x][y-1]==0) return true;// If above and below neighbours are zero return true
	        if(y<matrix[0].length-1&&matrix[x][y+1]==0) return true;
	        
	        return false;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		Matrix01 obj = new Matrix01();
		int[][] result = obj.updateMatrix(matrix);
		System.out.println(Arrays.asList(result));
	}

}
