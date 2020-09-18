// TC: O(M*N) where m is number of rows and N is number of columns in matrix.
// SC : O(M*N) to store matrix values in the queue.

// We need to check update the matrix with the distance of a cell with nearest 0. We add all the indices in the matrix which have value 0 and mark them as visited.
// as we don't have to visit cells which have value 0. So, now we will start checking our matrix cell which has values other than 0, we update its value
// with the curr cell we are exploring plus one since we updating the cell the distance nearest to 0. We will add that new queue value where we have found the value other than 0.
// We will explore its adjacents just to check the distance between its adjacents. This way, we continue to check for corresponding values.


import java.util.*;

public class ZeroOneMatrix {

	public int[][] Matrix10(int[][] matrix){
		
		if(matrix==null || matrix.length==0)
			return matrix;
		
		int m = matrix.length, n = matrix[0].length;
		
		Queue<int[]> q = new LinkedList<>();
		int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
		boolean[][] visited = new boolean[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j]==0){
					visited[i][j] = true;
					q.add(new int[] {i, j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			int[] curr = q.poll();
			
			for(int[] dir: dirs) {
				int newX = curr[0] + dir[0];
				int newY = curr[1] + dir[1];
				
				if(newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY])
					continue;
				
				matrix[newX][newY] = matrix[curr[0]][curr[1]] + 1;
				visited[newX][newY] = true;
				q.add(new int[] {newX, newY});
			}
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		
		ZeroOneMatrix zom = new ZeroOneMatrix();
		int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
		
		int[][] res = zom.Matrix10(matrix);
		
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[0].length;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
